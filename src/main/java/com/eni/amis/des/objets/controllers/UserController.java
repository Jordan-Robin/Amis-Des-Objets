package com.eni.amis.des.objets.controllers;

import com.eni.amis.des.objets.bll.UserServices;
import com.eni.amis.des.objets.bo.Adresse;
import com.eni.amis.des.objets.bo.Utilisateur;
import com.eni.amis.des.objets.bo.validation.UserValidationGroups;
import com.eni.amis.des.objets.exceptions.BusinessCode;
import com.eni.amis.des.objets.exceptions.BusinessException;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/create-profile")
    public String createProfile(Model model) {
        Adresse adresse = new Adresse();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse(adresse);
        model.addAttribute("utilisateur", utilisateur);
        return "create-profile";
    }

    @PostMapping("/create-profile")
    public String createProfile(
                                @RequestParam(name = "confirmation") String passwordConfirmation,
                                @Validated(UserValidationGroups.CreateUser.class) @ModelAttribute("utilisateur") Utilisateur utilisateur,
                                BindingResult bindingResult
                               ) {
        // Vérification de la correspondance des 2 mots de passe
        String password = utilisateur.getPassword();
        if (!password.equals(passwordConfirmation)) {
            ObjectError error = new ObjectError("globalError", BusinessCode.VALIDATION_USER_PASSWORD_MATCHING);
            bindingResult.addError(error);
        }

        if (bindingResult.hasErrors()) {
            return "create-profile";
        } else {
            try {
                this.userServices.createUser(utilisateur);
                return "redirect:/login";
            } catch (BusinessException e) {
                e.getClefsExternalisation().forEach(key -> {
                    ObjectError error = new ObjectError("globalError", key);
                    bindingResult.addError(error);
                });
                return "create-profile";
            }
        }
    }

    @GetMapping("/profile/{pseudo}")
    public String displayProfile(@PathVariable String pseudo, Model model) {
        Utilisateur utilisateur = this.userServices.getByPseudo(pseudo);
        model.addAttribute("user", utilisateur);
        return "display-profile";
    }

    @GetMapping("/profile/modify/{pseudo}")
    public String modifyProfile(@PathVariable String pseudo, Authentication authentication, Model model) {
        // Vérifie si la personne qui demande à accéder à cette fiche utilisateur est bien l'utilisateur lui-même
        if (authentication.getName().equals(pseudo)) {
            Utilisateur utilisateur = this.userServices.getByPseudo(pseudo);
            model.addAttribute("user", utilisateur);
            return "modify-profile";
        } else {
            return "redirect:/"; // TODO message d'erreur (user inconnu ou vous n'avez pas les droits)
        }
    }

    @PostMapping("/profile/modify/{pseudo}")
    public String modifyProfile(@Validated(UserValidationGroups.UpdateUser.class) @ModelAttribute("user") Utilisateur utilisateur,
            BindingResult bindingResult,
                                Authentication authentication) {
        // Vérifie si la personne qui demande à accéder à cette fiche utilisateur est bien l'utilisateur lui-même
        if (!authentication.getName().equals(utilisateur.getPseudo())) {
            return "redirect:/"; // TODO message d'erreur (user inconnu ou vous n'avez pas les droits)
        }

        if (bindingResult.hasErrors()) {
            return "modify-profile"; // TODO le crédit est affiché à zéro dans le template
        } else {
            try {
                this.userServices.modifyUser(utilisateur);
                return "redirect:/profile/" + utilisateur.getPseudo();
            } catch (BusinessException e) {
                e.getClefsExternalisation().forEach(key -> {
                    ObjectError error = new ObjectError("globalError", key);
                    bindingResult.addError(error);
                });
                return "create-profile";
            }
        }
    }

}