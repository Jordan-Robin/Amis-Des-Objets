package com.eni.amis.des.objets.bo;

import com.eni.amis.des.objets.bo.validation.UserValidationGroups;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class Adresse {

    private Integer id;

    @NotBlank(
            message = "La rue doit être renseignée.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class})
    @Length(
            max = 100,
            message = "La rue ne doit pas faire plus de 100 caractères.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class}
    )
    private String rue;

    @NotBlank(
            message = "Le code postal doit être renseigné.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class})
    @Length(
            max = 10,
            message = "Le code postal ne doit pas faire plus de 10 caractères.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class}
    )
    private String codePostal;

    @NotBlank(
            message = "La ville doit être renseignée.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class})
    @Length(
            max = 50,
            message = "La ville ne doit pas faire plus de 50 caractères.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class}
    )
    private String ville;

    private boolean adresseEni;

    public Adresse() {}

    public Adresse(Integer id, String rue, String codePostal, String ville, boolean adresseEni) {
        setId(id);
        setRue(rue);
        setCodePostal(codePostal);
        setVille(ville);
        setAdresseEni(adresseEni);
    }

    public Adresse(String rue, String codePostal, String ville, boolean adresseEni) {
        setRue(rue);
        setCodePostal(codePostal);
        setVille(ville);
        setAdresseEni(adresseEni);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public boolean isAdresseEni() {
        return adresseEni;
    }

    public void setAdresseEni(boolean adresseEni) {
        this.adresseEni = adresseEni;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", rue='" + rue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", adresseEni=" + adresseEni +
                '}';
    }

}
