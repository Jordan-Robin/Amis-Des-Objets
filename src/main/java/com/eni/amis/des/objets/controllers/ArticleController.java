package com.eni.amis.des.objets.controllers;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import com.eni.amis.des.objets.bo.Adresse;
import com.eni.amis.des.objets.bo.Categorie;
import com.eni.amis.des.objets.dal.AddressDAO;
import com.eni.amis.des.objets.dal.CategorieDAO;
import com.eni.amis.des.objets.bll.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private CategorieDAO categorieDAO;

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
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private List<Adresse> recupererToutesLesAdressesDirectement() {
        String sql = "SELECT no_adresse, rue, code_postal, ville, adresse_eni FROM ADRESSES";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Adresse adresse = new Adresse();
            adresse.setId(rs.getLong("no_adresse"));
            adresse.setRue(rs.getString("rue"));
            adresse.setCodePostal(rs.getString("code_postal"));
            adresse.setVille(rs.getString("ville"));
            adresse.setAdresseEni(rs.getBoolean("adresse_eni"));
            return adresse;
        });
    }
    
    @GetMapping("/sell-article")
    public String afficherFormulaireVente(Model model) {
        List<Categorie> categories = categorieDAO.getAllCategories();
        List<Adresse> adresses = recupererToutesLesAdressesDirectement();

        model.addAttribute("categories", categories);
        model.addAttribute("adresses", adresses);
        model.addAttribute("sellArticle", new ArticleAVendre());
        
        System.out.println("Catégories : " + categories);
        System.out.println("Adresses : " + adresses);

        return "sellArticle";
    }
    
    @PostMapping("/sell-article")
    public String traiterFormulaireVente(@ModelAttribute("sellArticle") ArticleAVendre article, Model model) {
        try {
            // Exemple : sauvegarder l'article via ArticleService (vous devrez le créer)
            articleService.saveArticle(article);

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
