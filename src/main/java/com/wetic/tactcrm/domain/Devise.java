package com.wetic.tactcrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "devises")
public class Devise extends EntiteBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull
    @Column(name = "symbole", nullable = false)
    private String symbole;


    @OneToMany(mappedBy = "devise")
    private Set<Facture> factures;

    @OneToMany(mappedBy = "devise")
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

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
}
