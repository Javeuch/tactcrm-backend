package com.wetic.tactcrm.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "details_factures")
public class DetailsFacture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prix_facure_ht")
    private Double prixFactureHt;

    @Column(name = "quantite")
    private Integer quantite;

    @ManyToOne
    @JsonIgnoreProperties("detailsFactures")
    private Facture facture;

    @ManyToOne
    @JsonIgnoreProperties("detailsFactures")
    private Article article;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrixFactureHt() {
        return prixFactureHt;
    }

    public void setPrixFactureHt(Double prixFactureHt) {
        this.prixFactureHt = prixFactureHt;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
