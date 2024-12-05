package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Adresse;
import com.eni.amis.des.objets.dal.AddressDAO;
import com.eni.amis.des.objets.dal.AddressDAOImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class AdresseServiceImpl implements AdresseService {
	
	//Tâche Vendre un Article
	 private final AddressDAO addressDAO;
	 
    // Injection via constructeur
    public AdresseServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }
  //Tâche Vendre un Article
	
//Mes modification pour la tâche vendre un article
//    private final AddressDAOImpl addressDAO;
//
//    public AdresseServiceImpl(AddressDAOImpl addressDAO) {
//        this.addressDAO = addressDAO;
//    }

    @Override
    public Adresse create(Adresse adresse) {
        return addressDAO.create(adresse);
    }

    @Override
    public Adresse findById(long id) {
        return addressDAO.findById(id);
    }

    @Override
    public void update(Adresse adresse) {
        addressDAO.update(adresse);
    }
    
  //Tâche Vendre un Article
    @Override
    public List<Adresse> getAllAddresses() {
    	return addressDAO.findAll(); // Retourne la liste complète d'objets Adresse
        // Exemple : récupérer toutes les adresses sous forme de chaîne
//        return addressDAO.findAll().stream()
//                .map(adresse -> adresse.getRue() + ", " + adresse.getCodePostal() + ", " + adresse.getVille())
//                .collect(Collectors.toList());
    }

}
