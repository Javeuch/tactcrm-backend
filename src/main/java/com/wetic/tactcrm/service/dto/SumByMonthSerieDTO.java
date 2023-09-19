package com.wetic.tactcrm.service.dto;

public class SumByMonthSerieDTO {
    private int mois;
    private Long montant;

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public SumByMonthSerieDTO(Long montant, int mois ) {
        this.mois = mois;
        this.montant = montant;
    }
    public SumByMonthSerieDTO(Double montant, int mois ) {
        this.mois = mois;
        if(montant==null){
            this.montant = Math.round(0.00);
        }else{
        this.montant = Math.round(montant);
        }
    }
}
