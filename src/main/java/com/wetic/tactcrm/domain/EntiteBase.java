package com.wetic.tactcrm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.EntityListeners;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntiteBase implements Serializable {

    @CreatedBy
    @Column(name = "cree_par", length = 50, updatable = true)
    private String creePar;

    @CreatedDate
    @Column(name = "date_creation", updatable = false)
    @JsonIgnore
    private Instant dateCreation = Instant.now();
	
	@LastModifiedBy
    @Column(name = "modifie_par", length = 50)
    private String modifiePar;
    
    @LastModifiedDate
    @Column(name = "date_modification")
    @JsonIgnore
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
