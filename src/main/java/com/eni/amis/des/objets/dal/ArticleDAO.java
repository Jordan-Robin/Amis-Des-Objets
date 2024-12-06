package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import java.util.List;

//Tâche Page d’accueil en mode déconnecté

public interface ArticleDAO {
    // Méthode pour récupérer les enchères actives
    List<ArticleAVendre> getEncheresActives();
    
    //--------------
    
    // Tâche Vendre un article
	void create(ArticleAVendre article);

	List<ArticleAVendre> findAll();
}

