package com.eni.amis.des.objets.controllers;

import com.eni.amis.des.objets.bll.UserServices;
import com.eni.amis.des.objets.bo.Adresse;
import com.eni.amis.des.objets.bo.Utilisateur;
import com.eni.amis.des.objets.exceptions.BusinessCode;
import com.eni.amis.des.objets.exceptions.BusinessException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                                @Valid @ModelAttribute("utilisateur") Utilisateur utilisateur,
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
                this.userServices.creerUtilisateur(utilisateur);
                return "redirect:/";
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