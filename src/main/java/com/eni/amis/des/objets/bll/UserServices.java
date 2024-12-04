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

    // TODO catch les erreurs dans la DAL pour confirmation à l'utilisateur de la bonne exécution du insert ou update
    private final UserDAOImpl userDAO;
    private final AddressDAOImpl addressDAO;
    private final PasswordEncoder passwordEncoder;

    public UserServices(UserDAOImpl userDAO, AddressDAOImpl addressDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.addressDAO = addressDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void createUser(Utilisateur utilisateur) {
        BusinessException be = new BusinessException();

        // Check if this pseudo is already used
        Utilisateur userCheckPseudo = userDAO.findByPseudo(utilisateur.getPseudo());
        if (userCheckPseudo != null) {
            be.add(BusinessCode.VALIDATION_USER_PSEUDO);
        }

        // Check if this email is already used
        Utilisateur userCheckEmail = userDAO.findByEmail(utilisateur.getEmail());
        if (userCheckEmail != null) {
            be.add(BusinessCode.VALIDATION_USER_EMAIL);
        }

        if (be.isValid()) {
            // Password hashing
            String hashedPassword = this.passwordEncoder.encode(utilisateur.getPassword());
            utilisateur.setPassword(hashedPassword);
            // Persist the address and user in database
            addressDAO.create(utilisateur.getAdresse());
            utilisateur.setCredit(10);
            userDAO.create(utilisateur);
        } else {
            throw be;
        }

    }

    @Transactional
    public void modifyUser(Utilisateur utilisateur) {
        System.out.println("user modifié :");
        System.out.println(utilisateur);
        // If this email is not already used by another user, update profile's datas.
        Utilisateur userCheckEmail = userDAO.findByEmail(utilisateur.getEmail());
        System.out.println("user checkmail :");
        System.out.println(userCheckEmail);
        if (userCheckEmail != null && !userCheckEmail.getPseudo().equals(utilisateur.getPseudo()) && userCheckEmail.getEmail().equals(utilisateur.getEmail())) {
            System.out.println("user déja ce mail :");
            System.out.println(userCheckEmail);
            BusinessException be = new BusinessException();
            be.add(BusinessCode.VALIDATION_USER_EMAIL);
            throw be;
        } else {
            addressDAO.update(utilisateur.getAdresse());
            userDAO.update(utilisateur);
        }
    }

    public Utilisateur getByPseudo(String pseudo) {
        Utilisateur utilisateur = userDAO.findByPseudo(pseudo);
        utilisateur.setAdresse(addressDAO.findById(utilisateur.getAdresse().getId()));
        return utilisateur;
    }

}