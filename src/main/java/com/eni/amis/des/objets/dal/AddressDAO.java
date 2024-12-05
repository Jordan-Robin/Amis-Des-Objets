package com.eni.amis.des.objets.dal;

import java.util.List;

import com.eni.amis.des.objets.bo.Adresse;

public interface AddressDAO {

    Adresse create(Adresse adresse);
    Adresse findById(long id);
    void update(Adresse adresse);
    
  //Tâche Vendre un Article
    // Nouvelle méthode pour récupérer toutes les adresses
    List<Adresse> findAll();

}
