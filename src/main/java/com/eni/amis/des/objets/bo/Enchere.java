package com.eni.amis.des.objets.bo;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class Enchere {

    private String idUtilisateur;

    private Integer idArticle;

    private LocalDateTime date;

    @NotNull(message = "Le montant doit être renseigné.")
    @Min(value = 1, message = "Le montant de l'enchère doit être supérieur ou égal à 1.")
    private Integer montant;

    public Enchere() {}

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Enchere{" +
                "idUtilisateur=" + idUtilisateur +
                ", idArticle=" + idArticle +
                ", date=" + date +
                ", montant=" + montant +
                '}';
    }

}
