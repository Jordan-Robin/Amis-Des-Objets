package com.eni.amis.des.objets.controllers.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eni.amis.des.objets.bo.Categorie;
import com.eni.amis.des.objets.dal.CategorieDAO;

@Component
public class StringToCategorieConverter implements Converter<String, Categorie> {

    @Autowired
    private CategorieDAO categorieDAO;

    @Override
    public Categorie convert(String source) {
        int noCategorie = Integer.parseInt(source);
        // Retourner un objet Categorie en fonction de son ID (noCategorie)
        return categorieDAO.getAllCategories()
                           .stream()
                           .filter(c -> c.getNoCategorie() == noCategorie)
                           .findFirst()
                           .orElse(null);
    }
}
