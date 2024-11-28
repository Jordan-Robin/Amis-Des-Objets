package com.eni.amis.des.objets.bo;

import java.time.LocalDate;

public class ArticleAVendre {
    private int noArticle;
    private String nomArticle;
	private String description;
	private int photo;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int statutEnchere; // 0, 1, 2, 3, 100
	private int prixInitial;
	private int prixVente;
	private String idUtilisateur;
	private int noCategorie;
	private int noAdresseRetrait;

    // Getters et Setters
    // toString, hashCode, equals si nécessaire
	
	public void setNoArticle(int noArticle) {
	    this.noArticle = noArticle;
	}

	public void setNomArticle(String nomArticle) {
	    this.nomArticle = nomArticle;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
	    this.dateDebutEncheres = dateDebutEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
	    this.dateFinEncheres = dateFinEncheres;
	}

	public void setStatutEnchere(int statutEnchere) {
	    this.statutEnchere = statutEnchere;
	}

	public void setPrixInitial(int prixInitial) {
	    this.prixInitial = prixInitial;
	}

	public void setPrixVente(int prixVente) {
	    this.prixVente = prixVente;
	}

}
