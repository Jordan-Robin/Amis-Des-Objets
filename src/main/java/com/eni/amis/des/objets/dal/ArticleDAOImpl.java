package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
}
