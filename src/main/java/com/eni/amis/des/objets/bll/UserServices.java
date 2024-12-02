package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Utilisateur;
import com.eni.amis.des.objets.dal.AddressDAOImpl;
import com.eni.amis.des.objets.dal.UserDAOImpl;
import com.eni.amis.des.objets.exceptions.BusinessCode;
import com.eni.amis.des.objets.exceptions.BusinessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServices {

    private final UserDAOImpl userDAO;
    private final AddressDAOImpl addressDAO;
    private final PasswordEncoder passwordEncoder;

    public UserServices(UserDAOImpl userDAO, AddressDAOImpl addressDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.addressDAO = addressDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void creerUtilisateur(Utilisateur utilisateur) {
        BusinessException be = new BusinessException();

        // Check if this pseudo is already used
        Utilisateur userCheckPseudo = this.userDAO.findByPseudo(utilisateur.getPseudo());
        if (userCheckPseudo != null ) {
            be.add(BusinessCode.VALIDATION_USER_PSEUDO);
        }

        // Check if this email is already used
        Utilisateur userCheckEmail = this.userDAO.findByEmail(utilisateur.getEmail());
        if (userCheckEmail != null ) {
            be.add(BusinessCode.VALIDATION_USER_EMAIL);
        }

        if (be.isValid()) {
            // Password hashing
            String hashedPassword = this.passwordEncoder.encode(utilisateur.getPassword());
            utilisateur.setPassword(hashedPassword);
            // Persist the address and user in database
            this.addressDAO.create(utilisateur.getAdresse());
            utilisateur.setCredit(10);
            this.userDAO.create(utilisateur);
        } else {
            throw be;
        }

    }

    public Utilisateur getByPseudo(String pseudo) {
        Utilisateur utilisateur = this.userDAO.findByPseudo(pseudo);
        utilisateur.setAdresse(this.addressDAO.findById(utilisateur.getAdresse().getId()));
        return utilisateur;
    }

}