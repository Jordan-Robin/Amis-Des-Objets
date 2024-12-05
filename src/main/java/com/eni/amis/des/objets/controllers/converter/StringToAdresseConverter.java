package com.eni.amis.des.objets.controllers.converter;

import com.eni.amis.des.objets.bll.AdresseService;
import com.eni.amis.des.objets.bo.Adresse;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
@Component
public class StringToAdresseConverter implements Converter<String, Adresse> {
    private final AdresseService adresseService;
    public StringToAdresseConverter(AdresseService adresseService) {
        this.adresseService = adresseService;
    }
    @Override
    public Adresse convert(String id) {
        int identifier = Integer.parseInt(id);
        return adresseService.findById(identifier);
    }

}
