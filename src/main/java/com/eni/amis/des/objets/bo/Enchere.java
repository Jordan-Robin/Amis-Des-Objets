package com.eni.amis.des.objets.bo;

import java.time.LocalDateTime;

public class Enchere {

    private Integer idUtilisateur;
    private Integer idArticle;
    private LocalDateTime date;
    private Integer montant;

    public Enchere() {}

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
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
