package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import com.eni.amis.des.objets.bo.Categorie;
import com.eni.amis.des.objets.dal.ArticleDAO;
import com.eni.amis.des.objets.dal.CategorieDAO;
import com.eni.amis.des.objets.dal.UserDAO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
	
	 private final ArticleDAO articleDAO;
	 private final CategorieDAO categorieDAO;
	 private final UserDAO userDAO;
	 
	 
     public ArticleService(ArticleDAO articleDAO, CategorieDAO categorieDAO, UserDAO userDAO) {
        this.articleDAO = articleDAO;
        this.categorieDAO = categorieDAO;
        this.userDAO = userDAO;
    }

    public List<ArticleAVendre> getEncheresActives() {
        return articleDAO.getEncheresActives();
    }
    
    //methode create, appel article DAO, tâche vendre un article
    
    public void create (ArticleAVendre article) {
    	articleDAO.create(article);
    }
    
    public void saveArticle (ArticleAVendre article, String pseudo) {
    	article.setUtilisateur(userDAO.findByPseudo(pseudo));
    	articleDAO.create(article);
    }
    
    public List<Categorie> getAllCategories() {
        return categorieDAO.getAllCategories();
    }
}