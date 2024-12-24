package com.eni.amis.des.objets.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eni.amis.des.objets.bo.Categorie;

@Repository
public class CategorieDAOImpl implements CategorieDAO {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public CategorieDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
  }

  private final String FIND_ALL = "SELECT no_categorie, libelle FROM CATEGORIES";
  private final String FIND_BY_ID = "SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie = :no_categorie";

  static class CategorieRowMapper implements RowMapper<Categorie> {
      @Override
      public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
          Categorie categorie = new Categorie();
          categorie.setId(rs.getInt("no_categorie"));
          categorie.setLibelle(rs.getString("libelle"));
          return categorie;
      }
  }

  public List<Categorie> findAll() {
      try {
          return jdbcTemplate.query(FIND_ALL, new CategorieRowMapper());
      } catch (EmptyResultDataAccessException e) {
          return null;
      }
  }

    @Override
    public Categorie findById(int id) {
        try {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("no_categorie", id);
            return jdbcTemplate.queryForObject(FIND_BY_ID, mapSqlParameterSource, new CategorieRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}