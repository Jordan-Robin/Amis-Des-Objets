package com.eni.amis.des.objets.controllers;

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

    @GetMapping("/create-profile")
    public String createProfile(Model model) {
        Utilisateur Utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", Utilisateur);
        return "create-profile";
    }

    @PostMapping("/create-profile")
    public String createProfile(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-profile";
        } else {
            try {
                // appel service
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
