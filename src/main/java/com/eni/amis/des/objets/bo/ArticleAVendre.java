package com.eni.amis.des.objets.bo;

import java.time.LocalDate;

public class ArticleAVendre {
    private Long noArticle;
	private String nomArticle;
	private String description;
	private Integer photo;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer statutEnchere;
	private Integer prixInitial;
	private Integer prixVente;
	private String idUtilisateur;
	private Categorie categorie;
	private Adresse adresse;

	public ArticleAVendre() {}

	public Long getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Long noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPhoto() {
		return photo;
	}

	public void setPhoto(Integer photo) {
		this.photo = photo;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public Integer getStatutEnchere() {
		return statutEnchere;
	}

	public void setStatutEnchere(Integer statutEnchere) {
		this.statutEnchere = statutEnchere;
	}

	public Integer getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "ArticleAVendre{" +
				"noArticle=" + noArticle +
				", nomArticle='" + nomArticle + '\'' +
				", description='" + description + '\'' +
				", photo=" + photo +
				", dateDebutEncheres=" + dateDebutEncheres +
				", dateFinEncheres=" + dateFinEncheres +
				", statutEnchere=" + statutEnchere +
				", prixInitial=" + prixInitial +
				", prixVente=" + prixVente +
				", idUtilisateur='" + idUtilisateur + '\'' +
				", categorie=" + categorie +
				", adresse=" + adresse +
				'}';
	}

}
