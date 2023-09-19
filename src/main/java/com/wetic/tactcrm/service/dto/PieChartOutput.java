package com.wetic.tactcrm.service.dto;

import java.util.List;

public class PieChartOutput {

    private List<MasterTypeDTO> factureByTypePaiement;

    private List<MasterTypeDTO> depenseByTypeDepense;

    public List<MasterTypeDTO> getFactureByTypePaiement() {
        return factureByTypePaiement;
    }

    public void setFactureByTypePaiement(List<MasterTypeDTO> factureByTypePaiement) {
        this.factureByTypePaiement = factureByTypePaiement;
    }

    public List<MasterTypeDTO> getDepenseByTypeDepense() {
        return depenseByTypeDepense;
    }

    public void setDepenseByTypeDepense(List<MasterTypeDTO> depenseByTypeDepense) {
        this.depenseByTypeDepense = depenseByTypeDepense;
    }
}
