package com.wetic.tactcrm.service.dto;

import java.util.Objects;
import java.util.Set;

public class DeviseDTO {

    private Long id;

    private String symbole;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviseDTO deviseDto = (DeviseDTO) o;
        return Objects.equals(id, deviseDto.id) &&
                Objects.equals(nom, deviseDto.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    @Override
    public String toString() {
        return "DeviseDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
