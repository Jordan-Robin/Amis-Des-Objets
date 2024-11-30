package com.eni.amis.des.objets.controllers;

import com.eni.amis.des.objets.bll.UserServices;
import com.eni.amis.des.objets.bo.Adresse;
import com.eni.amis.des.objets.bo.Utilisateur;
import com.eni.amis.des.objets.exceptions.BusinessException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/create-profile")
    public String createProfile(Model model) {
        System.out.println("entrée get");
        Adresse adresse = new Adresse();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse(adresse);
        model.addAttribute("utilisateur", utilisateur);
        return "create-profile";
    }

    @PostMapping("/create-profile")
    public String createProfile(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur,
                                BindingResult bindingResult) {
        System.out.println("entrée méthode post");
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
