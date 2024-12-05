package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import org.springframework.beans.factory.annotation.Autowired;
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

	// Formatter pour le format désiré
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ArticleAVendre> getEncheresActives() {
    	String sql = "SELECT * FROM ARTICLES_A_VENDRE WHERE statut_enchere = 1"; // 1 = En cours

        return jdbcTemplate.query(sql, new RowMapper<ArticleAVendre>() {
            @Override
            public ArticleAVendre mapRow(ResultSet rs, int rowNum) throws SQLException {
                ArticleAVendre article = new ArticleAVendre();
                article.setNoArticle(rs.getLong("no_article"));
                article.setNomArticle(rs.getString("nom_article"));
                article.setDescription(rs.getString("description"));
                article.setPrixInitial(rs.getInt("prix_initial"));
                article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
                article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
                article.setStatutEnchere(rs.getInt("statut_enchere"));
                article.setIdUtilisateur(rs.getString("id_utilisateur"));
                return article;
            }
        });
    }
    
    //Tâche Vendre un article, Insertion dans la base de données
    
    // Requête SQL pour insérer un article
    private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_A_VENDRE (nom_article, description, photo, date_debut_encheres, " +
            "date_fin_encheres, statut_enchere, prix_initial, prix_vente, id_utilisateur, no_categorie, no_adresse_retrait) " +
            "VALUES (:nomArticle, :description, :photo, :dateDebutEncheres, :dateFinEncheres, :statutEnchere, :prixInitial, " +
            ":prixVente, :idUtilisateur, :noCategorie, :noAdresseRetrait)";

 // Requête SQL pour récupérer tous les articles
    private static final String FIND_ALL_ARTICLES = "SELECT * FROM ARTICLES_A_VENDRE";
    
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Override
    public void create(ArticleAVendre article) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("nomArticle", article.getNomArticle());
        namedParameters.addValue("description", article.getDescription());
        namedParameters.addValue("photo", article.getPhoto());
        namedParameters.addValue("dateDebutEncheres", article.getDateDebutEncheres());
        namedParameters.addValue("dateFinEncheres", article.getDateFinEncheres());
        namedParameters.addValue("statutEnchere", article.getStatutEnchere());
        namedParameters.addValue("prixInitial", article.getPrixInitial());
        namedParameters.addValue("prixVente", article.getPrixVente());
        namedParameters.addValue("idUtilisateur", article.getIdUtilisateur());
        namedParameters.addValue("noCategorie", article.getCategorie());
        namedParameters.addValue("noAdresseRetrait", article.getAdresse());

        namedParameterJdbcTemplate.update(INSERT_ARTICLE, namedParameters);
    }
    
    @Override
    public List<ArticleAVendre> findAll() {
        return namedParameterJdbcTemplate.query(FIND_ALL_ARTICLES, 
            new BeanPropertyRowMapper<>(ArticleAVendre.class));
    }
    
   
}
