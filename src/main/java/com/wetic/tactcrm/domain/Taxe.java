package com.wetic.tactcrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "taxes")
public class Taxe extends EntiteBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull
    @Column(name = "taux", nullable = false)
    private Integer taux;

    @OneToMany(mappedBy = "taxe")
    private Set<Facture> factures;

    @OneToMany(mappedBy = "taxe")
    private Set<Article> articles;

    public Set<Facture> getFactures() {
        return factures;
    }

    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaux() {
        return taux;
    }

    public void setTaux(Integer taux) {
        this.taux = taux;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
