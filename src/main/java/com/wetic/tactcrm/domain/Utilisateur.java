package com.wetic.tactcrm.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Utilisateurs")

public class Utilisateur extends EntiteBase implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom", length = 100, nullable = false)
    private String nom;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prenom", length = 100, nullable = false)
    private String prenom;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "login", length = 50, unique = true, nullable = false)
    private String login;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;

    @Email
    @NotNull
    @Size(min = 5, max = 254)
    @Column(name="email", nullable = false)
    private String email;

    @Size(max = 100)
    @Column(name = "telephone", nullable = true)
    private String telephone;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Facture> factures;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Contrat> contrats;

    @OneToOne
    @JoinColumn(name = "adresse_id", referencedColumnName = "id")
    private Adresse adresse;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
    public Set<Facture> getFactures() {
        return factures;
    }

    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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


    //spring security props
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {

        return  password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // spring security classes ::ends

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


    public Set<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(Set<Contrat> contrats) {
        this.contrats = contrats;
    }

    public Utilisateur(String nom, String prenom, String login, String password, String email, String telephone, Boolean isAdmin) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.isAdmin = isAdmin;
    }

    public Utilisateur() {
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Utilisateur)){
            return false;
        }
        return id!=null && ((Utilisateur) o).id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode() * login.hashCode() * email.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                "}";
    }
}
