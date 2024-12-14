package com.eni.amis.des.objets.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eni.amis.des.objets.bo.Categorie;

@Repository
public class CategorieDAOImpl implements CategorieDAO {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public CategorieDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
  }

  private final String FIND_ALL = "SELECT no_categorie, libelle FROM CATEGORIES;";

  static class CategorieRowMapper implements RowMapper<Categorie> {
      @Override
      public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
          Categorie categorie = new Categorie();
          categorie.setNoCategorie(rs.getInt("no_categorie"));
          categorie.setLibelle(rs.getString("libelle"));
          return categorie;
      }
  }

  public List<Categorie> findAll() {
      return jdbcTemplate.query(FIND_ALL, new CategorieRowMapper());
  }

}