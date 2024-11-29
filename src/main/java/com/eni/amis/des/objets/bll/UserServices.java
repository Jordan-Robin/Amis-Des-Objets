package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Utilisateur;
import com.eni.amis.des.objets.exceptions.BusinessException;
import org.springframework.transaction.annotation.Transactional;

public class UserServices {

    @Transactional
    public void creerUtilisateur(Utilisateur utilisateur) {

        BusinessException be = new BusinessException();

        boolean isValid = true;
        // Tester les validations + (unicité du pseudo et vérification du mot de passe) : créer méthode DAL
        // qui vérifie si y'a un utilisateur avec cet email

        if (isValid) {
            // D'abord on insère l'utilisateur, puis on insère l'adresse
        } else {
            throw be;
        }

    }

}
