package com.eni.amis.des.objets.controllers.converter;

import com.eni.amis.des.objets.bll.AdresseService;
import com.eni.amis.des.objets.bo.Adresse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToAdresseConverter implements Converter<String, Adresse> {

    private final AdresseService adresseService;

    public StringToAdresseConverter(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @Override
    public Adresse convert(String source) {
        int id = Integer.parseInt(source);
        return this.adresseService.findById(id);
    }

}
