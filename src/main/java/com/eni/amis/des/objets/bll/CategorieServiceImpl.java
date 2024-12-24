package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Categorie;
import com.eni.amis.des.objets.dal.CategorieDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieDAO categorieDAO;

    public CategorieServiceImpl(CategorieDAO categorieDAO) {
        this.categorieDAO = categorieDAO;
    }

    @Override
    public Categorie findById(int id) {
        return this.categorieDAO.findById(id);
    }

    @Override
    public List<Categorie> findAll() {
        return this.categorieDAO.findAll();
    }

}
