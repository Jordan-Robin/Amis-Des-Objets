package com.eni.amis.des.objets.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class Adresse {

    private Long id;

    @NotBlank(message = "La rue doit être renseignée.")
    @Length(max = 100, message = "La rue ne doit pas faire plus de 100 caractères.")
    private String rue;

    @NotBlank(message = "Le code postal doit être renseigné.")
    @Length(max = 10, message = "Le code postal ne doit pas faire plus de 10 caractères.")
    private String codePostal;

    @NotBlank(message = "La ville doit être renseignée.")
    @Length(max = 50, message = "La ville ne doit pas faire plus de 50 caractères.")
    private String ville;

    public Adresse(Long id, String rue, String codePostal, String ville) {
        this.id = id;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Adresse(String rue, String codePostal, String ville) {
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", rue='" + rue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }

}
