package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDAOImpl implements ArticleDAO {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<ArticleAVendre> getEncheresActives() {
        String sql = "SELECT * FROM ARTICLES_A_VENDRE WHERE statut_enchere = 1";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ArticleAVendre article = new ArticleAVendre();
            article.setNoArticle(rs.getInt("no_article")); // Correspond à noArticle
            article.setNomArticle(rs.getString("nom_article")); // Correspond à nomArticle
            article.setDescription(rs.getString("description")); // Correspond à description
            // Ajoute d'autres champs si nécessaire (exemple : photo)
            article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate()); // Correspond à dateDebutEncheres
            article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate()); // Correspond à dateFinEncheres
            article.setStatutEnchere(rs.getInt("statut_enchere")); // Correspond à statutEnchere
            article.setPrixInitial(rs.getInt("prix_initial")); // Correspond à prixInitial
            article.setPrixVente(rs.getInt("prix_vente")); // Correspond à prixVente
            return article;
        });
    }

}
