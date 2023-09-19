package com.wetic.tactcrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "type_paiements")
public class TypePaiement extends EntiteBase{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "typePaiement")
    private Set<Facture> factures;

    @OneToMany(mappedBy = "typePaiement")
    private Set<Depense> depenses;


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

    public Set<Facture> getFactures() {
        return factures;
    }

    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }

    public Set<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(Set<Depense> depenses) {
        this.depenses = depenses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypePaiement that = (TypePaiement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(factures, that.factures) &&
                Objects.equals(depenses, that.depenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, factures, depenses);
    }

    @Override
    public String toString() {
        return "TypePaiement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", factures=" + factures +
                ", depenses=" + depenses +
                '}';
    }
}
