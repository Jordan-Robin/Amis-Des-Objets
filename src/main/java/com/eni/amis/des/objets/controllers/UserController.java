package com.eni.amis.des.objets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/create-profile")
    public String createProfile() {
        return "create-profile";
    }

}
