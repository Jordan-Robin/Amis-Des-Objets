package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.Article;
import java.util.List;

public interface ArticleDAO {

    List<Article> getEncheresActives();
	void create(Article article);
	List<Article> findAll();
}

