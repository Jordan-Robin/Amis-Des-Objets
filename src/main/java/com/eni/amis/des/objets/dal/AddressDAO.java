package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.Adresse;

public interface AddressDAO {

    Adresse create(Adresse adresse);
    Adresse findById(long id);
    void update(Adresse adresse);

}
