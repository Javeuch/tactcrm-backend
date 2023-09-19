package com.wetic.tactcrm.service.dto;

import java.util.Objects;
import java.util.Set;

public class TaxeDTO {

    private Long id;

    private Integer taux;

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxeDTO taxe = (TaxeDTO) o;
        return Objects.equals(id, taxe.id) &&
                Objects.equals(taux, taxe.taux);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taux);
    }

    @Override
    public String toString() {
        return "Taxe{" +
                "id=" + id +
                ", taux=" + taux +
                '}';
    }
}
