package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Utilisateur;
import com.eni.amis.des.objets.dal.UserDAO;
import com.eni.amis.des.objets.exceptions.BusinessCode;
import com.eni.amis.des.objets.exceptions.BusinessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServicesImpl implements UserServices{

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final AdresseService adresseService;

    public UserServicesImpl(UserDAO userDAO, PasswordEncoder passwordEncoder, AdresseService adresseService) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.adresseService = adresseService;
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

            adresseService.create(utilisateur.getAdresse());
            utilisateur.setCredit(10);
            userDAO.create(utilisateur);
        } else {
            throw be;
        }

    }

    @Transactional
    public void modifyUser(Utilisateur utilisateur) {
        // If this email is not already used by another user, update profile's datas.
        Utilisateur userCheckEmail = userDAO.findByEmail(utilisateur.getEmail());
        if (userCheckEmail != null && !userCheckEmail.getPseudo().equals(utilisateur.getPseudo()) && userCheckEmail.getEmail().equals(utilisateur.getEmail())) {
            BusinessException be = new BusinessException();
            be.add(BusinessCode.VALIDATION_USER_EMAIL);
            throw be;
        } else {
            adresseService.update(utilisateur.getAdresse());
            userDAO.update(utilisateur);
        }
    }

    public Utilisateur getByPseudo(String pseudo) {
        Utilisateur utilisateur = userDAO.findByPseudo(pseudo);
        utilisateur.setAdresse(adresseService.findById(utilisateur.getAdresse().getId()));
        return utilisateur;
    }

}