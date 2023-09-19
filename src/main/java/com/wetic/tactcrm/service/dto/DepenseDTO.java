package com.wetic.tactcrm.service.dto;

import java.util.Date;
import java.util.Objects;

public class DepenseDTO {

    private Long id;

    private String nom;

    private Date dateDepense;

    private String description;

    private Double montant;

    private Long deviseId;

    private Long typePaiementId;

    private Long typeDepenseId;

    public Long getTypeDepenseId() {
        return typeDepenseId;
    }

    public void setTypeDepenseId(Long typeDepenseId) {
        this.typeDepenseId = typeDepenseId;
    }

    public Long getTypePaiementId() {
        return typePaiementId;
    }

    public void setTypePaiementId(Long typePaiementId) {
        this.typePaiementId = typePaiementId;
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


    public Long getDeviseId() {
        return deviseId;
    }

    public void setDeviseId(Long deviseId) {
        this.deviseId = deviseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepenseDTO that = (DepenseDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(dateDepense, that.dateDepense) &&
                Objects.equals(description, that.description) &&
                Objects.equals(montant, that.montant) &&
                Objects.equals(deviseId, that.deviseId) &&
                Objects.equals(typePaiementId, that.typePaiementId) &&
                Objects.equals(typeDepenseId, that.typeDepenseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, dateDepense, description, montant, deviseId, typePaiementId, typeDepenseId);
    }

    @Override
    public String toString() {
        return "DepenseDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateDepense=" + dateDepense +
                ", description='" + description + '\'' +
                ", montant=" + montant +
                ", deviseId=" + deviseId +
                ", typePaiementId=" + typePaiementId +
                ", typeDepenseId=" + typeDepenseId +
                '}';
    }
}
