package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Adresse;
import com.eni.amis.des.objets.dal.AddressDAO;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AdresseServiceImpl implements AdresseService {

    private final AddressDAO addressDAO;

    public AdresseServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    public Adresse create(Adresse adresse) {
        return addressDAO.create(adresse);
    }

    @Override
    public Adresse findById(int id) {
        return addressDAO.findById(id);
    }

    @Override
    public void update(Adresse adresse) {
        addressDAO.update(adresse);
    }

    @Override
    public List<Adresse> getAllAddresses() {
    	return addressDAO.findAll();
    }

}
