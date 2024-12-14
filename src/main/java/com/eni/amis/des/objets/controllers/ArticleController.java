package com.eni.amis.des.objets.controllers;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import com.eni.amis.des.objets.bo.Adresse;
import com.eni.amis.des.objets.bo.Categorie;
import com.eni.amis.des.objets.dal.CategorieDAOImpl;
import com.eni.amis.des.objets.bll.AdresseService;
import com.eni.amis.des.objets.bll.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ArticleController {
	
    private final ArticleService articleService;
    private final AdresseService adresseService;

    public ArticleController(ArticleService articleService, AdresseService addressService) {
        this.articleService = articleService;
        this.adresseService = addressService;
    }
    
    @Autowired
    private CategorieDAOImpl categorieDAOImpl;

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
        List<Categorie> categories = categorieDAOImpl.getAllCategories();
        List<Adresse> adresses = adresseService.getAllAddresses(); 
        //List<String> adresses = adresseService.getAllAddresses();
       // List<Adresse> adresses = recupererToutesLesAdressesDirectement();

        model.addAttribute("categories", categories);
        model.addAttribute("adresses", adresses);
        model.addAttribute("sellArticle", new ArticleAVendre());
        
        System.out.println("Catégories : " + categories);
        System.out.println("Adresses : " + adresses);

        return "sellArticle";
    }
    
    @PostMapping("/sell-article")
    public String traiterFormulaireVente(@ModelAttribute("sellArticle") ArticleAVendre article, Model model, Principal principal) {
        if (article.getCategorie() == null || article.getCategorie().getNoCategorie() == 0) {
            model.addAttribute("error", "Veuillez sélectionner une catégorie valide.");
            return "sellArticle";
        }
    	try {
        	
            //Sauvegarder l'article via ArticleService
            articleService.saveArticle(article, principal.getName());

            // Ajouter un message de succès dans le modèle
            model.addAttribute("message", "Article mis en vente avec succès !");
            return "redirect:/"; // Redirige vers la page d'accueil
        } catch (Exception e) {
            // En cas d'erreur, afficher un message et revenir au formulaire
            model.addAttribute("error", "Erreur lors de la mise en vente de l'article.");
            model.addAttribute("sellArticle", article); // Recharger l'article
            return "sellArticle"; // Retour au formulaire
        }
    }
    
}
