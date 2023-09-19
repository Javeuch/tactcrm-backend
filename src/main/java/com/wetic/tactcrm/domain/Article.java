package com.wetic.tactcrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

//Désignation: String-  Description: String-  Taxe: int-  Prix de vente: double-  Prix d'achat: double
@Entity
@Table(name = "articles")
public class Article extends EntiteBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "designation", nullable = false)
    private String designation;

    @NotNull
    @Column(name = "prix_vente",nullable = false)
    private Double prixVente;

    @ManyToOne
    @JoinColumn(name = "taxe_id")
    private Taxe taxe;

    @OneToMany(mappedBy = "article")
    private Set<DetailsFacture> detailsFactures;

    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }


    public Set<DetailsFacture> getDetailsFactures() {
        return detailsFactures;
    }

    public void setDetailsFactures(Set<DetailsFacture> detailsFactures) {
        this.detailsFactures = detailsFactures;
    }
}
