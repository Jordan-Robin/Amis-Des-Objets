package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Enchere;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnchereService {

    void create(Enchere enchere);
    Enchere findByIds(Integer idUtilisateur, Integer idArticle);
    List<Enchere> findAllByArticle(Integer idArticle);
    List<Enchere> findAllByUser(Integer idUtilisateur);
    List<Enchere> findAll();


}
