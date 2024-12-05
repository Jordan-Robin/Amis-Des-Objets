package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

//Tâche Page d’accueil en mode déconnecté

@Repository
public class ArticleDAOImpl implements ArticleDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ArticleDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ArticleAVendre> getEncheresActives() {
        String sql = "SELECT * FROM ARTICLES_A_VENDRE WHERE statut_enchere = 1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ArticleAVendre.class));
    }

    @Override
    public void create(ArticleAVendre article) {
    
    String sql = "INSERT INTO ARTICLES_A_VENDRE (nom_article, description, date_debut_encheres, " +
                "date_fin_encheres, statut_enchere, prix_initial, id_utilisateur, no_categorie, no_adresse_retrait) " +
                "VALUES (:nomArticle, :description, :dateDebutEncheres, :dateFinEncheres, :statutEnchere, :prixInitial, " +
                ":idUtilisateur, :noCategorie, :noAdresseRetrait)";

   MapSqlParameterSource params = new MapSqlParameterSource();
   params.addValue("nomArticle", article.getNomArticle());
   params.addValue("description", article.getDescription());
   params.addValue("dateDebutEncheres", article.getDateDebutEncheres());
   params.addValue("dateFinEncheres", article.getDateFinEncheres());
   params.addValue("statutEnchere", article.getStatutEnchere() != null ? article.getStatutEnchere() : 0);
   params.addValue("prixInitial", article.getPrixInitial());
   params.addValue("idUtilisateur", article.getUtilisateur().getPseudo());
   //params.addValue("noCategorie", article.getCategorie());
   params.addValue("noCategorie", article.getCategorie() != null ? article.getCategorie().getNoCategorie() : null);
   //params.addValue("noAdresseRetrait", article.getAdresse());
   params.addValue("noAdresseRetrait", article.getAdresse() != null ? article.getAdresse().getId() : -1);

   
   try {
	    jdbcTemplate.update(sql, params);
	} catch (DataAccessException e) {
	    e.printStackTrace();
	    throw new RuntimeException("Error during INSERT operation", e);
	}
   }

    @Override
    public List<ArticleAVendre> findAll() {
        String sql = "SELECT * FROM ARTICLES_A_VENDRE";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ArticleAVendre.class));
    }
}
