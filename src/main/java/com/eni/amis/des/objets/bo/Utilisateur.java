package com.eni.amis.des.objets.bo;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public class Utilisateur {

    @NotBlank(message = "Le pseudo est obligatoire.")
    @Length(max = 30, message = "Le pseudo ne doit pas dépasser 30 caractères.")
    @Pattern(
            regexp = "^[a-zA-Z0-9_]+$",
            message = "Le pseudo n'accepte que des caractères alphanumériques ainsi que le symbole '_'."
    )
    private String pseudo;

    @NotBlank(message = "Le nom est obligatoire.")
    @Length(max = 40, message = "Le nom ne doit pas dépasser 40 caractères.")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire.")
    @Length(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères.")
    private String prenom;

    @NotBlank(message = "L'email est obligatoire.")
    @Email(message = "L'email doit être valide.")
    private String email;

    @Pattern(
            regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$",
            message = "Le numéro de téléphone doit être valide."
    )
    private String telephone;

    @NotBlank(message = "Le mot de passe est obligatoire.")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "Le mot de passe doit comporter entre 8 et 20 caractères, au moins une majuscule, un caractère spécial et un chiffre."
    )
    private String password;

    @Min(value = 0, message = "Le crédit ne peut pas être négatif.")
    private int credit;
    private boolean admin;

    private Adresse adresse;

    public Utilisateur() {}

    public Utilisateur(
            String pseudo,
            String nom,
            String prenom,
            String email,
            String telephone,
            String password,
            int credit,
            boolean admin,
            Adresse adresse
                      ) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.credit = credit;
        this.admin = admin;
        this.adresse = adresse;
    }



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
