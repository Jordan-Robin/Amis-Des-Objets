package com.eni.amis.des.objets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eni.amis.des.objets.dal.ArticleDAO;
import com.eni.amis.des.objets.bo.ArticleAVendre;

@Controller
@RequestMapping("/")
public class ArticleController {
    @Autowired
    private ArticleDAO articleDAO;

    @GetMapping("/encheres/actives")
    public String afficherEncheresActives(Model model) {
        List<ArticleAVendre> encheresActives = articleDAO.getEncheresActives();
        model.addAttribute("encheres", encheresActives);
        return "encheresActives";
    }
}
