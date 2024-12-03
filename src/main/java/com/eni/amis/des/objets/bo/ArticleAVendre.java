package com.eni.amis.des.objets.bo;

import java.time.LocalDate;

// Tâche Page d’accueil en mode déconnecté

public class ArticleAVendre {
    private int noArticle;
    public int getNoArticle() {
		return noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public int getPhoto() {
		return photo;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public int getStatutEnchere() {
		return statutEnchere;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public int getNoAdresseRetrait() {
		return noAdresseRetrait;
	}
	
	public String getFormattedDate() {
	    return formattedDate;
	}

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
	private String formattedDate;

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

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	public void setFormattedDate(String formattedDate) {
	    this.formattedDate = formattedDate;
	}

}
