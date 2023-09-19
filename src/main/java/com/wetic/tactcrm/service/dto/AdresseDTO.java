package com.wetic.tactcrm.service.dto;


import java.util.Objects;


public class AdresseDTO  {

    private Long id;

    private String rue;

    private String localite;

    private String ville;


    private String pays;

    private Long utilisateurId;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresseDTO that = (AdresseDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(rue, that.rue) &&
                Objects.equals(localite, that.localite) &&
                Objects.equals(ville, that.ville) &&
                Objects.equals(pays, that.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rue, localite, ville, pays);
    }

    @Override
    public String toString() {
        return "AdresseDto{" +
                "id=" + id +
                ", rue='" + rue + '\'' +
                ", localite='" + localite + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
