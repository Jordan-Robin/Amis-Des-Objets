package com.eni.amis.des.objets.bo;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class Article {

    private Integer id;

    @NotBlank(message = "Le nom de l'article ne peut pas être vide.")
    @Size(max = 30, message = "Le nom de l'article ne doit pas dépasser 30 caractères.")
    private String nom;

    @NotBlank(message = "La description ne peut pas être vide.")
    @Size(max = 300, message = "La description ne doit pas dépasser 300 caractères.")
    private String description;

    @NotNull(message = "La date de début des enchères est obligatoire.")
    private LocalDate dateDebutEncheres;

    @NotNull(message = "La date de fin des enchères est obligatoire.")
    private LocalDate dateFinEncheres;

    @NotNull(message = "Le prix est obligatoire.")
    @Min(value = 1, message = "Le prix initial doit être supérieur ou égal à 1.")
    private Integer prixInitial;

    private Integer prixVente;

    private Statut statut;

    private Utilisateur utilisateur;

    private Categorie categorie;

    private Adresse adresse;

    public Article() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
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

    /**
     * Énumération représentant l'attribut "Statut".
     */
    public enum Statut {

        PAS_COMMENCE(0, "Pas commencée"),
        EN_COURS(1, "En cours"),
        CLOTURE(2, "Cloturée"),
        LIVRE(3, "Livrée"),
        ANNULE(4, "Annulée");

        private final int code;
        private final String description;

        Statut(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        public static Statut fromCode(int code) {
            for (Statut statut : Statut.values()) {
                if (statut.code == code) {
                    return statut;
                }
            }
            throw new IllegalArgumentException("Code statut inconnu : " + code);
        }

    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", dateDebutEncheres=" + dateDebutEncheres +
                ", dateFinEncheres=" + dateFinEncheres +
                ", prixInitial=" + prixInitial +
                ", prixVente=" + prixVente +
                ", statut=" + statut +
                ", utilisateur=" + utilisateur +
                ", categorie=" + categorie +
                ", adresse_retrait=" + adresse +
                '}';
    }

}

