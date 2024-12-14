package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import com.eni.amis.des.objets.bo.Categorie;
import com.eni.amis.des.objets.dal.ArticleDAO;
import com.eni.amis.des.objets.dal.CategorieDAOImpl;
import com.eni.amis.des.objets.dal.UserDAO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
	
	 private final ArticleDAO articleDAO;
	 private final CategorieDAOImpl categorieDAOImpl;
	 private final UserDAO userDAO;
	 
	 
     public ArticleService(ArticleDAO articleDAO, CategorieDAOImpl categorieDAOImpl, UserDAO userDAO) {
        this.articleDAO = articleDAO;
        this.categorieDAOImpl = categorieDAOImpl;
        this.userDAO = userDAO;
    }
     
     //--------Tâche Encheres Actives ----------

    public List<ArticleAVendre> getEncheresActives() {
        return articleDAO.getEncheresActives();
    }
    
    //-------Tâches Encheres Actives ----------
    
    
    
    //methode create, appel article DAO, Tâche vendre un article
    
    public void create (ArticleAVendre article) {
    	articleDAO.create(article);
    }
    
    public void saveArticle (ArticleAVendre article, String pseudo) {
    	article.setUtilisateur(userDAO.findByPseudo(pseudo));
    	articleDAO.create(article);
    }
    
    public List<Categorie> getAllCategories() {
        return categorieDAOImpl.getAllCategories();
    }
}