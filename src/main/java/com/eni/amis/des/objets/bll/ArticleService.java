package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import com.eni.amis.des.objets.dal.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Tâche Page d’accueil en mode déconnecté, Encheres Actives

@Service
public class ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    public List<ArticleAVendre> getEncheresActives() {
        return articleDAO.getEncheresActives();
    }
    
    //methode create, appel article DAO, tâche vendre un article
    
    public void create (ArticleAVendre article) {
    	articleDAO.create(article);
    }
    
    public void saveArticle (ArticleAVendre article) {
    	articleDAO.create(article);
    }
}