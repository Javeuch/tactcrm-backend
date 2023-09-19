package com.wetic.tactcrm.service.dto;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;



public class ArticleDTO {

    private Long id;

    private String designation;

    private Double prixVente;

    private Long taxeId;

    private TaxeDTO taxeDto;

    public TaxeDTO getTaxeDto() {
        return taxeDto;
    }

    public void setTaxeDto(TaxeDTO taxeDto) {
        this.taxeDto = taxeDto;
    }

    public Long getTaxeId() {
        return taxeId;
    }

    public void setTaxeId(Long taxeId) {
        this.taxeId = taxeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleDTO that = (ArticleDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(designation, that.designation) &&
                Objects.equals(prixVente, that.prixVente) &&
                Objects.equals(taxeId, that.taxeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, prixVente, taxeId);
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", prixVente=" + prixVente +
                ", taxe=" + taxeId +
                '}';
    }
}
