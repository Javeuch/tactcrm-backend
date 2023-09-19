package com.wetic.tactcrm.service.dto;

import java.util.Objects;
import java.util.Set;

public class TypeDepenseDTO {

    private Long id;
    private String nom;

    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDepenseDTO that = (TypeDepenseDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "TypeDepense{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
