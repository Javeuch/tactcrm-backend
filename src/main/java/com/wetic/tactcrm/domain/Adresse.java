package com.wetic.tactcrm.domain;


import javax.persistence.*;

@Entity
@Table(name = "adresses")
public class Adresse extends EntiteBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "rue", nullable = true)
    private String rue;

    @Column(name = "localite", nullable = true)
    private String localite;

    @Column(name = "ville", nullable = true)
    private String ville;

    @Column(name = "pays", nullable = true)
    private String pays;

    @OneToOne(mappedBy = "adresse")
    private Utilisateur utilisateur;


    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Adresse)){
            return false;
        }
        return id!=null && ((Adresse) o).id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode() * rue.hashCode() * localite.hashCode();
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "rue='" + rue + '\'' +
                ", localite='" + localite + '\'' +
                ", Ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                "}";
    }



}
