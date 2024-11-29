package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.ArticleAVendre;
import com.eni.amis.des.objets.dal.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    public List<ArticleAVendre> getEncheresActives() {
        return articleDAO.getEncheresActives();
    }
}