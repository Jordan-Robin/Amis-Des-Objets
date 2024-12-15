package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Article;
import com.eni.amis.des.objets.dal.ArticleDAO;

import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	 private final ArticleDAO articleDAO;
	 
     public ArticleServiceImpl(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }
    
    public void create (Article article) {
    	articleDAO.create(article);
    }

}