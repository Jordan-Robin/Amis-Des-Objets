package com.eni.amis.des.objets.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public class Categorie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

	@NotNull(message = "Le numéro de catégorie est obligatoire.")
    private Integer id;

	@NotBlank(message = "Le libellé de la catégorie ne peut pas être vide.")
    @Size(max = 30, message = "Le libellé de la catégorie ne doit pas dépasser 30 caractères.")
    private String libelle;

    public Categorie() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }

}
