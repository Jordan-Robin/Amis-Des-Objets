package com.eni.amis.des.objets.controllers;

import com.eni.amis.des.objets.bll.ArticleService;
import com.eni.amis.des.objets.bll.CategorieService;
import com.eni.amis.des.objets.bo.Adresse;
import com.eni.amis.des.objets.bo.Article;
import com.eni.amis.des.objets.bll.AdresseService;
import com.eni.amis.des.objets.bo.Categorie;
import com.eni.amis.des.objets.exceptions.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@SessionAttributes({"categoriesSession", "adressesSession"})
public class ArticleController {

    private final ArticleService articleService;
    private final AdresseService adresseService;
    private final CategorieService categorieService;

    public ArticleController(ArticleService articleService, AdresseService addressService,
                             CategorieService categorieService) {
        this.articleService = articleService;
        this.adresseService = addressService;
        this.categorieService = categorieService;
    }

    @ModelAttribute("categoriesSession")
    public List<Categorie> loadCategoriesSession() {
        return this.categorieService.findAll();
    }

    @ModelAttribute("adressesSession")
    public List<Adresse> loadAdressesSession() {
        return this.adresseService.getAllAddresses();
    }

    @GetMapping("/")
    public String afficherEncheresActives(Model model) {
        List<Article> liste_articles_active = articleService.findAllActives();
        model.addAttribute("encheres", liste_articles_active);
        return "home";
    }

    @GetMapping("/sell-article")
    public String afficherFormulaireVente(Model model) {
        Article article = new Article();
        model.addAttribute("article", article);
        return "sell-article";
    }

    @PostMapping("/sell-article")
    public String traiterFormulaireVente(@Validated @ModelAttribute("article") Article article,
                                         BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "sell-article";
        } else {
            this.articleService.create(article, principal.getName());
            return "redirect:/";
        }
    }

}