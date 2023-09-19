package com.wetic.tactcrm.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;


public class FactureDTO {

    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateFacturation;

    private String numeroFacture;

    private Long utilisateurId;

    private Long deviseId;

    private Long taxeId;

    private String taxeNom;

    private String utilisateurNom;

    private String typePaiementNom;


    private Long typePaiementId;

    public String getTaxeNom() {
        return taxeNom;
    }

    public void setTaxeNom(String taxeNom) {
        this.taxeNom = taxeNom;
    }

    public String getUtilisateurNom() {
        return utilisateurNom;
    }

    public void setUtilisateurNom(String utilisateurNom) {
        this.utilisateurNom = utilisateurNom;
    }

    public String getTypePaiementNom() {
        return typePaiementNom;
    }

    public void setTypePaiementNom(String typePaiementNom) {
        this.typePaiementNom = typePaiementNom;
    }


    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Long getDeviseId() {
        return deviseId;
    }

    public void setDeviseId(Long deviseId) {
        this.deviseId = deviseId;
    }

    public Long getTaxeId() {
        return taxeId;
    }

    public void setTaxeId(Long taxeId) {
        this.taxeId = taxeId;
    }

    public Long getTypePaiementId() {
        return typePaiementId;
    }

    public void setTypePaiementId(Long typePaiementId) {
        this.typePaiementId = typePaiementId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactureDTO facture = (FactureDTO) o;
        return Objects.equals(id, facture.id) &&
                Objects.equals(dateFacturation, facture.dateFacturation) &&
                Objects.equals(numeroFacture, facture.numeroFacture) &&
                Objects.equals(deviseId, facture.deviseId) &&
                Objects.equals(taxeId, facture.taxeId) &&
                Objects.equals(typePaiementId, facture.typePaiementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateFacturation, numeroFacture, deviseId, taxeId, typePaiementId);
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", dateFacturation=" + dateFacturation +
                ", numeroFacture='" + numeroFacture + '\'' +
                ", deviseId=" + deviseId +
                ", taxeId=" + taxeId +
                ", typePaiementId=" + typePaiementId +
                '}';
    }
}
