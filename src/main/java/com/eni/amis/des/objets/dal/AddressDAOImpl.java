package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.Adresse;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl implements AddressDAO {

    private final String INSERT_ADDRESS = "INSERT INTO ADRESSES (rue, code_postal, ville, adresse_eni) VALUES (:rue, " +
            ":codepostal, :ville, :adresseeni)";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AddressDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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

}
