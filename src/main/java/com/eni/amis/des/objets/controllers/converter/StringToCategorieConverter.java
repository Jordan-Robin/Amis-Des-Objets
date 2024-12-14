package com.eni.amis.des.objets.controllers.converter;

import com.eni.amis.des.objets.bll.CategorieService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eni.amis.des.objets.bo.Categorie;

@Component
public class StringToCategorieConverter implements Converter<String, Categorie> {

    private final CategorieService categorieService;

    public StringToCategorieConverter(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @Override
    public Categorie convert(String id) {
        int identifier = Integer.parseInt(id);
        return categorieService.findById(identifier);
    }

}