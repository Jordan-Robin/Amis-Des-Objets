package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Utilisateur;
import com.eni.amis.des.objets.exceptions.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServices {

    @Transactional
    public void creerUtilisateur(Utilisateur utilisateur) {
        System.out.println(utilisateur);

// En tant qu’utilisateur, je peux m’inscrire sur la plateforme Enchères.org. Le pseudo doit être unique sur toute la
// plateforme, ainsi que l’email. Le pseudo n’accepte que des caractères alphanumériques et ‘_’. Si la création du
// profil est validée, l’utilisateur est dirigé vers la page d’accueil (liste des enchères). Le crédit initial est de 10. Utiliser la classe org.springframework.security.crypto.factory.PasswordEncoderFactories pour chiffre le mot de passe dans la BLL. Utiliser du JS pour valider l’égalité des 2 mots de passe et le pattern. Gestion des transactions

/*
        BusinessException be = new BusinessException();

        boolean isValid = true;
        // Tester les validations + (unicité du pseudo et vérification du mot de passe) : créer méthode DAL
        // qui vérifie si y'a un utilisateur avec cet email

        if (isValid) {
            // D'abord on insère l'utilisateur, puis on insère l'adresse
        } else {
            throw be;
        }
*/
    }

}
