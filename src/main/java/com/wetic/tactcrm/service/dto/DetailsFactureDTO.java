package com.wetic.tactcrm.service.dto;

import java.util.Objects;


public class DetailsFactureDTO {

    private Long id;

    private Double prixFactureHt;

    private Integer quantite;

    private Long factureId;

    private Long articleId;

    private String articleDesignation;

    private TaxeDTO taxeDto;

    public TaxeDTO getTaxeDto() {
        return taxeDto;
    }

    public void setTaxeDto(TaxeDTO taxeDto) {
        this.taxeDto = taxeDto;
    }

    public String getArticleDesignation() {
        return articleDesignation;
    }

    public void setArticleDesignation(String articleDesignation) {
        this.articleDesignation = articleDesignation;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFactureId() {
        return factureId;
    }

    public void setFactureId(Long factureId) {
        this.factureId = factureId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailsFactureDTO that = (DetailsFactureDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(prixFactureHt, that.prixFactureHt) &&
                Objects.equals(quantite, that.quantite) &&
                Objects.equals(factureId, that.factureId) &&
                Objects.equals(articleId, that.articleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prixFactureHt, quantite, factureId, articleId);
    }

    @Override
    public String toString() {
        return "DetailsFactureDto{" +
                "id=" + id +
                ", prixFactureHt=" + prixFactureHt +
                ", quantite=" + quantite +
                ", factureId=" + factureId +
                ", articleId=" + articleId +
                '}';
    }
}
