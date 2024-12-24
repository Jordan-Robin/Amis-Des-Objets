package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Enchere;
import com.eni.amis.des.objets.dal.EnchereDAOImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnchereServiceImpl implements EnchereService{

    private final EnchereDAOImpl enchereDAO;

    public EnchereServiceImpl(EnchereDAOImpl enchereDAO) {
        this.enchereDAO = enchereDAO;
    }

    @Override
    public void create(Enchere enchere) {}

    @Override
    public Enchere findByIds(Integer idUtilisateur, Integer idArticle) {
        return null;
    }

    @Override
    public List<Enchere> findAllByArticle(Integer idArticle) {
        return null;
    }

    @Override
    public List<Enchere> findAllByUser(Integer idUtilisateur) {
        return null;
    }

    @Override
    public List<Enchere> findAll() {
        return enchereDAO.findAll();
    }

}
