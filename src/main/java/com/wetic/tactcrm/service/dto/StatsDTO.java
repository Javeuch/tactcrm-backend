package com.wetic.tactcrm.service.dto;

public class StatsDTO {
    private long countProduitVendue;
    private long countClient;
    private long sumDepense;
    private long sumProfit;

    public long getSumProfit() {
        return sumProfit;
    }

    public void setSumProfit(long sumProfit) {
        this.sumProfit = sumProfit;
    }

    public long getCountProduitVendue() {
        return countProduitVendue;
    }
    public void setCountProduitVendue(long countProduitVendue) {
        this.countProduitVendue = countProduitVendue;
    }
    public long getCountClient() {
        return countClient;
    }
    public void setCountClient(long countClient) {
        this.countClient = countClient;
    }
    public long getSumDepense() {
        return sumDepense;
    }
    public void setSumDepense(long sumDepense) {
        this.sumDepense = sumDepense;
    }
}
