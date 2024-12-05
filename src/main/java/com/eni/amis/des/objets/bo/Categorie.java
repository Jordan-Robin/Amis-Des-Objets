package com.eni.amis.des.objets.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
//Tâche Vendre un Article

public class Categorie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

	@NotNull(message = "Le numéro de catégorie est obligatoire.")
    private int noCategorie;

	@NotBlank(message = "Le libellé de la catégorie ne peut pas être vide.")
    @Size(max = 30, message = "Le libellé de la catégorie ne doit pas dépasser 30 caractères.")
    private String libelle;

    public Categorie(int noCategorie, String libelle) {
        this.noCategorie = noCategorie;
        this.libelle = libelle;
    }

    public int getNoCategorie() {
        return noCategorie;
    }

    public void setNoCategorie(int noCategorie) {
        this.noCategorie = noCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "noCategorie=" + noCategorie +
                ", libelle='" + libelle + ')';
    }
}
