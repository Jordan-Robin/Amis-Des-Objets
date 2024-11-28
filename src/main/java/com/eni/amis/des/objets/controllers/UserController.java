package com.eni.amis.des.objets.controllers;

import com.eni.amis.des.objets.bo.Utilisateur;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/create-profile")
    public String createProfile() {
        return "create-profile";
    }

    @PostMapping("/create-profile")
    public String createProfile(@Valid @ModelAttribute("utilisateur")Utilisateur utilisateur, BindingResult bindingResult) {
        return "redirect:/";
    }

}
