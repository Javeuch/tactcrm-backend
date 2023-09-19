package com.wetic.tactcrm.service.dto;

public class MasterTypeDTO {
    private Long utilisations;
    private String libelle;

    public Long getUtilisations() {
        return utilisations;
    }

    public void setUtilisations(Long utilisations) {
        this.utilisations = utilisations;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public MasterTypeDTO(Long utilisations, String libelle) {
        //todo fix intial state in case of empty db
        this.libelle = libelle;
        if(utilisations==null){
            this.utilisations = Math.round(0.00);
        }else{
            this.utilisations = utilisations;
        }
    }
}
