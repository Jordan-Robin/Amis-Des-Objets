package com.eni.amis.des.objets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("article/")
public class ArticleController {

    @GetMapping("")
    public String article() {
        return "article";
    }

}
