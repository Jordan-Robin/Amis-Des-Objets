package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.Adresse;
import com.eni.amis.des.objets.bo.Utilisateur;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAOImpl implements UserDAO {

    private final String INSERT_USER = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, " +
            "mot_de_passe, credit, administrateur, no_adresse) VALUES (:pseudo, :nom, :prenom, :email, :telephone, " +
            ":password, :credit, :administrateur, :noAdresse)";
    private final String SELECT_BY_PSEUDO = "SELECT pseudo, nom, prenom, email, telephone, credit, administrateur, no_adresse FROM UTILISATEURS WHERE pseudo = :pseudo";
    private final String SELECT_BY_EMAIL = "SELECT pseudo, nom, prenom, email, telephone, credit, administrateur, " +
            "no_adresse FROM UTILISATEURS WHERE email = :email";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    static class UserRowMapper implements RowMapper<Utilisateur> {
        @Override
        public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setPseudo(rs.getString("pseudo"));
            utilisateur.setNom(rs.getString("nom"));
            utilisateur.setPrenom(rs.getString("prenom"));
            utilisateur.setEmail(rs.getString("email"));
            utilisateur.setTelephone(rs.getString("telephone"));
            utilisateur.setCredit(rs.getInt("credit"));
            utilisateur.setAdmin(rs.getBoolean("administrateur"));

            Adresse adresse = new Adresse();
            adresse.setId(rs.getLong("no_adresse"));
            utilisateur.setAdresse(adresse);
            return utilisateur;
        }
    }

    @Override
    public void create(Utilisateur utilisateur) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("pseudo", utilisateur.getPseudo());
        namedParameters.addValue("nom", utilisateur.getNom());
        namedParameters.addValue("prenom", utilisateur.getPrenom());
        namedParameters.addValue("email", utilisateur.getEmail());
        namedParameters.addValue("telephone", utilisateur.getTelephone());
        namedParameters.addValue("password", utilisateur.getPassword());
        namedParameters.addValue("credit", utilisateur.getCredit());
        namedParameters.addValue("administrateur", utilisateur.isAdmin());
        namedParameters.addValue("noAdresse", utilisateur.getAdresse().getId());

        jdbcTemplate.update(INSERT_USER, namedParameters);
    }

    @Override
    public Utilisateur findByPseudo(String pseudo) {
        try {
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            namedParameters.addValue("pseudo", pseudo);
            return jdbcTemplate.queryForObject(SELECT_BY_PSEUDO, namedParameters, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Utilisateur findByEmail(String email) {
        try {
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            namedParameters.addValue("email", email);
            return jdbcTemplate.queryForObject(SELECT_BY_EMAIL, namedParameters, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}