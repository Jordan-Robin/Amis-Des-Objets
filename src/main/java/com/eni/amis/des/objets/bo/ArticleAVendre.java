package com.eni.amis.des.objets.bo;

//Tâche Article à Vendre

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ArticleAVendre {
  private int noArticle;

  @NotBlank(message = "Le nom de l'article ne peut pas être vide.")
  @Size(max = 30, message = "Le nom de l'article ne doit pas dépasser 30 caractères.")
  private String nomArticle;

  @NotBlank(message = "La description ne peut pas être vide.")
  @Size(max = 300, message = "La description ne doit pas dépasser 300 caractères.")
  private String description;

  private Integer photo;

  @NotNull(message = "La date de début des enchères est obligatoire.")
  private LocalDate dateDebutEncheres;

  @NotNull(message = "La date de fin des enchères est obligatoire.")
  private LocalDate dateFinEncheres;

  @NotNull(message = "Le statut de l'enchère est obligatoire.")
  private Integer statutEnchere;

  @NotNull(message = "Le prix initial est obligatoire.")
  @Min(value = 1, message = "Le prix initial doit être supérieur ou égal à 1.")
  private Integer prixInitial;

  private Integer prixVente;

  @NotBlank(message = "L'identifiant de l'utilisateur est obligatoire.")
  @Size(max = 30, message = "L'identifiant de l'utilisateur ne doit pas dépasser 30 caractères.")
  private String idUtilisateur;

  @NotNull(message = "La catégorie est obligatoire.")
  private Categorie categorie;

  @NotNull(message = "L'adresse de retrait est obligatoire.")
  private Adresse adresse;
	public ArticleAVendre() {}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int i) {
		this.noArticle = i;
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
	
	public String getFormattedDate() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    return this.dateFinEncheres != null ? this.dateFinEncheres.format(formatter) : "Date non définie";
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

