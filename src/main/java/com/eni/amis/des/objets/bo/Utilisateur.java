package com.eni.amis.des.objets.bo;

import com.eni.amis.des.objets.bo.validation.UserValidationGroups;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public class Utilisateur {

    @NotBlank(message = "Le pseudo est obligatoire.", groups = {UserValidationGroups.CreateUser.class})
    @Length(
            max = 30,
            message = "Le pseudo ne doit pas dépasser 30 caractères.",
            groups = {UserValidationGroups.CreateUser.class})
    @Pattern(
            regexp = "^[a-zA-Z0-9_]+$",
            message = "Le pseudo n'accepte que des caractères alphanumériques ainsi que le symbole '_'.",
            groups = {UserValidationGroups.CreateUser.class})
    private String pseudo;

    @NotBlank(
            message = "Le nom est obligatoire.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class})
    @Length(
            max = 40,
            message = "Le nom ne doit pas dépasser 40 caractères.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class})
    private String nom;

    @NotBlank(
            message = "Le prénom est obligatoire.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class})
    @Length(max = 50,
            message = "Le prénom ne doit pas dépasser 50 caractères.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class}
    )
    private String prenom;

    @NotBlank(
            message = "L'email est obligatoire.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class})
    @Email(
            message = "L'email doit être valide.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class})
    private String email;

    @Pattern(
            regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$",
            message = "Le numéro de téléphone doit être valide.",
            groups = {UserValidationGroups.UpdateUser.class, UserValidationGroups.CreateUser.class}
    )
    private String telephone;

    @NotBlank(
            message = "Le mot de passe est obligatoire.",
            groups = {UserValidationGroups.CreateUser.class})
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "Le mot de passe doit comporter entre 8 et 20 caractères, au moins une majuscule, un caractère " +
                    "spécial et un chiffre.",
            groups = {UserValidationGroups.CreateUser.class})
    private String password;

    private int credit;
    private boolean admin;

    @Valid
    private Adresse adresse;

    public Utilisateur() {}

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "pseudo='" + pseudo + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", credit=" + credit +
                ", admin=" + admin +
                ", adresse=" + adresse +
                '}';
    }

}
