package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Article;

import java.util.List;

public interface ArticleService {

    void create(Article article, String creatorPseudo);
    List<Article> findAll();
    List<Article> findAllActives();

}
