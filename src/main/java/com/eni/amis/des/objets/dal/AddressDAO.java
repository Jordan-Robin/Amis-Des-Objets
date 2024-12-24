package com.eni.amis.des.objets.dal;

import java.util.List;

import com.eni.amis.des.objets.bo.Adresse;

public interface AddressDAO {

    Adresse create(Adresse adresse);
    Adresse findById(int id);
    void update(Adresse adresse);
    List<Adresse> findAll();

}
