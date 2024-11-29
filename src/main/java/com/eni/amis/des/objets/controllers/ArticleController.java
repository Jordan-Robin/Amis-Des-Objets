package com.eni.amis.des.objets.controllers;


import com.eni.amis.des.objets.bo.ArticleAVendre;
import com.eni.amis.des.objets.bll.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String afficherEncheresActives(Model model) {
        // Récupérer les enchères actives via le service
        List<ArticleAVendre> encheresActives = articleService.getEncheresActives();
        // Ajouter les enchères au modèle pour les afficher dans la vue
        model.addAttribute("encheres", encheresActives);
        return "index"; // Retourner la vue index.html
    }
}
