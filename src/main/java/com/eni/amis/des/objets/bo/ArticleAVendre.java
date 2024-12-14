package com.eni.amis.des.objets.bo;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

public class ArticleAVendre {

    private Integer noArticle;

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

//    @NotNull(message = "Le statut de l'enchère est obligatoire.")
//    private Integer statutEnchere;

    @NotNull(message = "Le prix initial est obligatoire.")
    @Min(value = 1, message = "Le prix initial doit être supérieur ou égal à 1.")
    private Integer prixInitial;

    private Integer prixVente;

    @NotBlank(message = "L'identifiant de l'utilisateur est obligatoire.")
    @Size(max = 30, message = "L'identifiant de l'utilisateur ne doit pas dépasser 30 caractères.")
    private Utilisateur utilisateur;

    @NotNull(message = "La catégorie est obligatoire.")
    private Categorie categorie;

    @NotNull(message = "L'adresse de retrait est obligatoire.")
    private Adresse adresse;
    public ArticleAVendre() {
    	this.utilisateur = new Utilisateur();
    }

    public Integer getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(Integer noArticle) {
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

//    public Integer getStatutEnchere() {
//        return statutEnchere;
//    }
//
//    public void setStatutEnchere(Integer statutEnchere) {
//        this.statutEnchere = statutEnchere;
//    }

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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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
    
    //Résoudre SQL Warning dans la console et formulaire
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Le statut de l'enchère est obligatoire.")
    private StatutEnchere statutEnchere;

    public StatutEnchere getStatutEnchere() {
        return statutEnchere;
    }

    public void setStatutEnchere(StatutEnchere statutEnchere) {
        this.statutEnchere = statutEnchere;
    }

    
    public enum StatutEnchere {
        PAS_COMMENCEE(0), EN_COURS(1), CLOTUREE(2), LIVREE(3), ANNULEE(100);

        private final Integer code;

        StatutEnchere(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static StatutEnchere fromCode(int code) {
            for (StatutEnchere statut : values()) {
                if (statut.getCode() == code) {
                    return statut;
                }
            }
            throw new IllegalArgumentException("Statut inconnu pour le code : " + code);
        }
    }
    
    @AssertTrue(message = "La date de début doit être antérieure à la date de fin.")
    public boolean isDatesValides() {
        if (dateDebutEncheres != null && dateFinEncheres != null) {
            return dateDebutEncheres.isBefore(dateFinEncheres);
        }
        return true; // Laisse Jakarta Validation gérer les champs null
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
                ", utilisateur='" + utilisateur + '\'' +
                ", categorie=" + categorie +
                ", adresse=" + adresse +
                '}';
    }

}

