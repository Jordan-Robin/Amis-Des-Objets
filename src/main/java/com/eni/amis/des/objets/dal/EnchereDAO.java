package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.Enchere;

import java.util.List;

public interface EnchereDAO {

    List<Enchere> findAll();
    void create(Enchere enchere);

}
