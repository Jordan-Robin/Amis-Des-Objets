package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.Adresse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AddressDAOImpl implements AddressDAO {

    private final String INSERT_ADDRESS = "INSERT INTO ADRESSES (rue, code_postal, ville, adresse_eni) VALUES (:rue, " +
            ":codepostal, :ville, :adresseeni)";
    private final String SELECT_BY_ID = "SELECT no_adresse, rue, code_postal, ville, adresse_eni FROM ADRESSES WHERE " +
            "no_adresse = :no_adresse";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AddressDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    static class AddressRowMapper implements RowMapper<Adresse> {
        @Override
        public Adresse mapRow(ResultSet rs, int rowNum) throws SQLException {
            Adresse adresse = new Adresse();
            adresse.setId(rs.getLong("no_adresse"));
            adresse.setRue(rs.getString("rue"));
            adresse.setCodePostal(rs.getString("code_postal"));
            adresse.setVille(rs.getString("ville"));
            adresse.setAdresseEni(rs.getBoolean("adresse_eni"));
            return adresse;
        }
    }

    @Override
    public Adresse create(Adresse adresse) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("rue", adresse.getRue());
        namedParameters.addValue("codepostal", adresse.getCodePostal());
        namedParameters.addValue("ville", adresse.getVille());
        namedParameters.addValue("adresseeni", adresse.isAdresseEni());

        this.jdbcTemplate.update(INSERT_ADDRESS, namedParameters, keyHolder);
        if (keyHolder != null && keyHolder.getKey() != null) {
            adresse.setId(keyHolder.getKey().longValue());
        }
        return adresse;
    }

    @Override
    public Adresse findById(long id) {
        try {
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            namedParameters.addValue("no_adresse", id);
            return jdbcTemplate.queryForObject(SELECT_BY_ID, namedParameters, new AddressRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}