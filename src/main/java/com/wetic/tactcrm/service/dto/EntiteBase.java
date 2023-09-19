package com.wetic.tactcrm.service.dto;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

public class EntiteBase {

    private String creePar;

    private Instant dateCreation = Instant.now();

    private String modifiePar;

    private Instant dateModification = Instant.now();

    public String getCreePar() {
        return creePar;
    }

    public void setCreePar(String creePar) {
        this.creePar = creePar;
    }

    public Instant getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Instant dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getModifiePar() {
        return modifiePar;
    }

    public void setModifiePar(String modifiePar) {
        this.modifiePar = modifiePar;
    }

    public Instant getDateModification() {
        return dateModification;
    }

    public void setDateModification(Instant dateModification) {
        this.dateModification = dateModification;
    }

}
