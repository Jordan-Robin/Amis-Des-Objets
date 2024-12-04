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

  //Tâche Page d’accueil en mode déconnecté
    @GetMapping("/")
    public String afficherEncheresActives(Model model) {
        // Récupérer les enchères actives via le service
        List<ArticleAVendre> encheresActives = articleService.getEncheresActives();
        // Ajouter les enchères au modèle pour les afficher dans la vue
        model.addAttribute("encheres", encheresActives);
        return "index"; // Retourner la vue index.html
    }
    
  //Tâche Vendre un article
    
    @GetMapping("/sell-article")
    public String afficherFormulaireVente(Model model) {
        // Ajouter les catégories et adresses dans le modèle
    	//IMPORTANT! Faut qu'on récupère les catégories et les adresses dans la base de données
        model.addAttribute("categories", List.of("Ameublement", "Informatique", "Sport/Loisirs", "Vêtements"));
        model.addAttribute("adresses", List.of("Adresse 1", "Adresse 2", "Adresse 3"));
        return "sellArticle";
    }
}
