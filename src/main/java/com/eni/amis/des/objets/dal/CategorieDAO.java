package com.eni.amis.des.objets.dal;

//-----Tâche Vendre un Article

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eni.amis.des.objets.bo.Categorie;

@Repository
public class CategorieDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Categorie> getAllCategories() {
      String sql = "SELECT no_categorie, libelle FROM CATEGORIES";
      return jdbcTemplate.query(sql, (rs, rowNum) -> 
          new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"))
      );
  }
}