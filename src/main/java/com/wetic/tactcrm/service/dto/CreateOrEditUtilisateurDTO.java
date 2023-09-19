package com.wetic.tactcrm.service.dto;


import java.util.Objects;


public class CreateOrEditUtilisateurDTO{
    private static final long serialVersionUID = 1L;

    private Long id ;

    private String nom;

    private String prenom;

    private String login;

    private String password;

    private String email;

    private String telephone;

    private Long adresseId;

    private AdresseDTO adresse;

    private Boolean isAdmin;

    public Long getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(Long adresseId) {
        this.adresseId = adresseId;
    }


    public AdresseDTO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDTO adresse) {
        this.adresse = adresse;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrEditUtilisateurDTO that = (CreateOrEditUtilisateurDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(isAdmin, that.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, login, password, email, telephone, isAdmin);
    }

    public CreateOrEditUtilisateurDTO() {
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
