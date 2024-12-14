package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.Categorie;

import java.util.List;

public interface CategorieDAO {

    List<Categorie> findAll();

}
