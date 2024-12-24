package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Article;
import com.eni.amis.des.objets.dal.ArticleDAO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDAO articleDAO;
    private final UserServices userServices;
    private final CategorieService categorieService;
    private final AdresseService adresseService;

    public ArticleServiceImpl(
            ArticleDAO articleDAO,
            UserServices userServices,
            CategorieService categorieService1,
            AdresseService adresseService
                             ) {
        this.articleDAO = articleDAO;
        this.userServices = userServices;
        this.categorieService = categorieService1;
        this.adresseService = adresseService;
    }

    @Override
    public void create(Article article, String creatorPseudo) {
        article.setUtilisateur(this.userServices.getByPseudo(creatorPseudo));
        article.setStatut(Article.Statut.PAS_COMMENCE);
        articleDAO.create(article);
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public List<Article> findAllActives() {
        List<Article> articles_list = this.articleDAO.getEncheresActives();

        for (Article article : articles_list) {
            article.setUtilisateur(this.userServices.getByPseudo(article.getUtilisateur().getPseudo()));
            article.setCategorie(this.categorieService.findById(article.getCategorie().getId()));
            article.setAdresse(this.adresseService.findById(article.getAdresse().getId()));
        }

        return articles_list;
    }


}