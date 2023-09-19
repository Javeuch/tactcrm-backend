package com.wetic.tactcrm.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class FactureViewDTO {

    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateFacturation;

    private String numeroFacture;

    private Long utilisateurId;

    private Long deviseId;

    private Long taxeId;

    private UtilisateurDTO utilisateurDTO;

    private TypePaiementDTO typePaiementDTO;

    private AdresseDTO clientAdressDTO;

    private DeviseDTO deviseDTO;

    public DeviseDTO getDeviseDTO() {
        return deviseDTO;
    }

    public void setDeviseDTO(DeviseDTO deviseDTO) {
        this.deviseDTO = deviseDTO;
    }

    public AdresseDTO getClientAdressDTO() {
        return clientAdressDTO;
    }

    public void setClientAdressDTO(AdresseDTO clientAdressDTO) {
        this.clientAdressDTO = clientAdressDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Long getDeviseId() {
        return deviseId;
    }

    public void setDeviseId(Long deviseId) {
        this.deviseId = deviseId;
    }

    public Long getTaxeId() {
        return taxeId;
    }

    public void setTaxeId(Long taxeId) {
        this.taxeId = taxeId;
    }

    public UtilisateurDTO getUtilisateurDTO() {
        return utilisateurDTO;
    }

    public void setUtilisateurDTO(UtilisateurDTO utilisateurDTO) {
        this.utilisateurDTO = utilisateurDTO;
    }

    public TypePaiementDTO getTypePaiementDTO() {
        return typePaiementDTO;
    }

    public void setTypePaiementDTO(TypePaiementDTO typePaiementDTO) {
        this.typePaiementDTO = typePaiementDTO;
    }
}
