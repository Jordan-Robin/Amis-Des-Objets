package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.Enchere;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EnchereDAOImpl implements EnchereDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public EnchereDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String FIND_ALL = "SELECT id_utilisateur, no_article, montant_enchere, date_enchere FROM ENCHERES";

    @NonNullApi
    private static class EnchereRowMapper implements RowMapper<Enchere> {
        @Override
        public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {
            Enchere enchere = new Enchere();
            enchere.setIdUtilisateur(rs.getString("id_utilisateur"));
            enchere.setIdArticle(rs.getInt("no_article"));
            enchere.setMontant(rs.getInt("montant_enchere"));
            enchere.setDate(rs.getTimestamp("date_enchere").toLocalDateTime());
            return enchere;
        }
    }

    @Override
    public List<Enchere> findAll() {
        try {
            return jdbcTemplate.query(FIND_ALL, new EnchereRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void create(Enchere enchere) {
        // TODO Attention il faut gérer l'erreur si un user fait une enchère avec un montant qu'il a déjà fait sur un
        //  même article
    }

}
