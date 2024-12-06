package com.eni.amis.des.objets.bll;

import java.util.List;

import com.eni.amis.des.objets.bo.Adresse;

public interface AdresseService {

    Adresse create(Adresse adresse);
    Adresse findById(long id);
    void update(Adresse adresse);
    List<Adresse> getAllAddresses();

}
