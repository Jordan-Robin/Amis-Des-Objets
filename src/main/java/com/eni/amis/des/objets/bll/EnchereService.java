package com.eni.amis.des.objets.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.eni.amis.des.objets.bo.EnchereDetail;

// Tâche Gestion des enchères - Afficher le détail d’une enchère Tu peux le modifier

@Service
public class EnchereService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Méthode pour récupérer les détails d'une enchère
    //@SuppressWarnings("deprecation")
	public EnchereDetail getDetailEnchere(int id) {
        String sql = "SELECT a.nom_article, a.description, a.date_fin_encheres, a.prix_initial, \r\n"
        		+ "       COALESCE(a.prix_vente, 0) AS meilleureOffre,  -- Utilise 0 comme valeur par défaut\r\n"
        		+ "       u.pseudo AS vendeur, c.libelle AS categorie, \r\n"
        		+ "       ad.rue + ', ' + ad.code_postal + ' ' + ad.ville AS adresseRetrait\r\n"
        		+ "FROM ARTICLES_A_VENDRE a\r\n"
        		+ "JOIN UTILISATEURS u ON a.id_utilisateur = u.pseudo\r\n"
        		+ "JOIN CATEGORIES c ON a.no_categorie = c.no_categorie\r\n"
        		+ "JOIN ADRESSES ad ON a.no_adresse_retrait = ad.no_adresse\r\n"
        		+ "WHERE a.no_article = ?\r\n";

        // Exécuter la requête et mapper les résultats sur la classe EnchereDetail
        return jdbcTemplate.queryForObject(
            sql,
            new Object[]{id},
            new BeanPropertyRowMapper<>(EnchereDetail.class)
        );
    }
}