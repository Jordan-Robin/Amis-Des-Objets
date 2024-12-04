package com.eni.amis.des.objets.controllers;

//Tâche Gestion des enchères - Afficher le détail d’une enchère

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eni.amis.des.objets.bll.EnchereService;
import com.eni.amis.des.objets.bo.EnchereDetail;

@Controller
public class EnchereController {

  @Autowired
  private EnchereService enchereService;

  @GetMapping("/DetailVente/{id}")
  public String afficherDetailVente(@PathVariable("id") int id, Model model) {
      // Récupérer les détails de l'enchère via le service
      EnchereDetail enchereDetail = enchereService.getDetailEnchere(id);

      // Ajouter les détails au modèle pour la vue
      model.addAttribute("enchereDetails", enchereDetail);

      // Retourner la vue "DetailVente"
      return "DetailVente";
  }
}
