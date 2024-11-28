package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import java.util.List;

public interface ArticleDAO {
    // Méthode pour récupérer les enchères actives
    List<ArticleAVendre> getEncheresActives();
}

