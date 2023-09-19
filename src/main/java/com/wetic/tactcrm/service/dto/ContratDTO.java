package com.wetic.tactcrm.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

public class ContratDTO extends EntiteBase {

    private Long id;

    private String sujet;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateDebut;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateFin;

    private String description;

    private String typeContrat;

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

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContratDTO that = (ContratDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sujet, that.sujet) &&
                Objects.equals(dateDebut, that.dateDebut) &&
                Objects.equals(dateFin, that.dateFin) &&
                Objects.equals(description, that.description) &&
                Objects.equals(typeContrat, that.typeContrat) &&
                Objects.equals(utilisateurId, that.utilisateurId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sujet, dateDebut, dateFin, description, typeContrat, utilisateurId);
    }

    @Override
    public String toString() {
        return "ContratDto{" +
                "id=" + id +
                ", sujet='" + sujet + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", description='" + description + '\'' +
                ", typeContrat='" + typeContrat + '\'' +
                ", utilisateur=" + utilisateurId +
                '}';
    }
}
