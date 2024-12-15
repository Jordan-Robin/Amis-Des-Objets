package com.eni.amis.des.objets.controllers;

import com.eni.amis.des.objets.bll.EnchereService;
import com.eni.amis.des.objets.bo.Enchere;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EnchereController {

  private final EnchereService enchereService;

  public EnchereController(EnchereService enchereService) {
      this.enchereService = enchereService;
  }

  @GetMapping("/DetailVente/{id}")
  public String afficherDetailVente(@PathVariable("id") int id, Model model) {
      // Récupérer les détails de l'enchère via le service
      Enchere enchereDetail = enchereService.findByIds(1, 1);

      // Ajouter les détails au modèle pour la vue
      model.addAttribute("enchereDetails", enchereDetail);

      // Retourner la vue "DetailVente"
      return "DetailVente";
  }
}
