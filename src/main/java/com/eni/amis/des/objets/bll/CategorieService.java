package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie findById(int id);
    List<Categorie> findAll();

}
