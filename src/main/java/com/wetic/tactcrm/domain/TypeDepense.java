package com.wetic.tactcrm.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Type_depenses")
public class TypeDepense extends EntiteBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;


    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "typeDepense")
    private Set<Depense> depenses;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(Set<Depense> depenses) {
        this.depenses = depenses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
