package com.eni.amis.des.objets.controllers.converter;

import com.eni.amis.des.objets.bo.Adresse;
import org.springframework.core.convert.converter.Converter;

public class StringToAdresseConverter implements Converter<String, Adresse> {

    @Override
    public Adresse convert(String id) {
        return null;
    }

}
