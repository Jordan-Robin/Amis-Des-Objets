package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.Adresse;
import com.eni.amis.des.objets.bo.Article;
import com.eni.amis.des.objets.bo.Categorie;
import com.eni.amis.des.objets.bo.Utilisateur;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

    private final String FIND_ALL_ACTIVES_ARTICLES = "SELECT * FROM ARTICLES_A_VENDRE WHERE statut_enchere = 1";
    private final String INSERT = "INSERT INTO ARTICLES_A_VENDRE (nom_article, description, date_debut_encheres, " +
            "date_fin_encheres, statut_enchere, prix_initial, id_utilisateur, no_categorie, no_adresse_retrait) " +
            "VALUES (:nomArticle, :description, :dateDebutEncheres, :dateFinEncheres, :statutEnchere, :prixInitial, " +
            ":idUtilisateur, :noCategorie, :noAdresseRetrait)";
    private final String FIND_ALL = "SELECT * FROM ARTICLES_A_VENDRE";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ArticleDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static class ArticleRowMapper implements RowMapper<Article> {

        @Override
        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
            Article article = new Article();
            article.setId(rs.getInt("no_article"));
            article.setNom(rs.getString("nom_article"));
            article.setDescription(rs.getString("description"));
            article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
            article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
            article.setStatut(Article.Statut.fromCode(rs.getInt("statut_enchere")));
            article.setPrixInitial(rs.getInt("prix_initial"));
            article.setPrixVente(rs.getInt("prix_vente"));

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setPseudo(rs.getString("id_utilisateur"));
            article.setUtilisateur(utilisateur);

            Categorie categorie = new Categorie();
            categorie.setId(rs.getInt("no_categorie"));
            article.setCategorie(categorie);

            Adresse adresseRetrait = new Adresse();
            adresseRetrait.setId(rs.getInt("no_adresse_retrait"));
            article.setAdresse(adresseRetrait);

            return article;
        }

    }

    @Override
    public List<Article> getEncheresActives() {
        try {
            return jdbcTemplate.query(FIND_ALL_ACTIVES_ARTICLES, new ArticleRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void create(Article article) {
       MapSqlParameterSource params = new MapSqlParameterSource();
       params.addValue("nomArticle", article.getNom());
       params.addValue("description", article.getDescription());
       params.addValue("dateDebutEncheres", article.getDateDebutEncheres());
       params.addValue("dateFinEncheres", article.getDateFinEncheres());
       params.addValue("statutEnchere", article.getStatut().getCode());
       params.addValue("prixInitial", article.getPrixInitial());
       params.addValue("idUtilisateur", article.getUtilisateur().getPseudo());
       params.addValue("noCategorie", article.getCategorie().getId());
       params.addValue("noAdresseRetrait", article.getAdresse().getId());

       jdbcTemplate.update(INSERT, params);
   }

    @Override
    public List<Article> findAll() {
        try {
            return jdbcTemplate.query(FIND_ALL, new ArticleRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}