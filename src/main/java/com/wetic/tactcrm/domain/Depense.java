package com.wetic.tactcrm.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "depenses")
public class Depense extends EntiteBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom")
    private String nom;

    @NotNull
    @Column(name = "date_depense")
    private Date dateDepense;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "montant", nullable = false)
    private Double montant;


    @ManyToOne
    @JoinColumn(name = "devise_id" )
    private Devise devise;

    @ManyToOne
    @JoinColumn(name = "type_paiement_id")
    private TypePaiement typePaiement;

    @ManyToOne
    @JoinColumn(name = "type_depense_id")
    private TypeDepense typeDepense;

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public TypeDepense getTypeDepense() {
        return typeDepense;
    }

    public void setTypeDepense(TypeDepense typeDepense) {
        this.typeDepense = typeDepense;
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

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }


}
