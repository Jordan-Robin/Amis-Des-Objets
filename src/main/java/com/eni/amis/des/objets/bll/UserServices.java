package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Utilisateur;
import com.eni.amis.des.objets.dal.AddressDAOImpl;
import com.eni.amis.des.objets.dal.UserDAOImpl;
import com.eni.amis.des.objets.exceptions.BusinessCode;
import com.eni.amis.des.objets.exceptions.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServices {

    private final UserDAOImpl userDAO;
    private final AddressDAOImpl addressDAO;

    public UserServices(UserDAOImpl userDAO, AddressDAOImpl addressDAO) {
        this.userDAO = userDAO;
        this.addressDAO = addressDAO;
    }

    @Transactional
    public void creerUtilisateur(Utilisateur utilisateur) {
        BusinessException be = new BusinessException();

        // Check if this pseudo is already used.
        Utilisateur userCheckPseudo = this.userDAO.findByPseudo(utilisateur.getPseudo());
        if (userCheckPseudo != null ) {
            be.add(BusinessCode.VALIDATION_USER_PSEUDO);
        }

        // Check if this email is already used.
        Utilisateur userCheckEmail = this.userDAO.findByEmail(utilisateur.getEmail());
        if (userCheckEmail != null ) {
            be.add(BusinessCode.VALIDATION_USER_PSEUDO);
        }

        if (be.isValid()) {
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