package com.wetic.tactcrm.service.dto;

import java.util.List;

public class LineChartOutput {

    private List<SumByMonthSerieDTO> sumProfitByMonth;

    private List<SumByMonthSerieDTO> sumDepenseByMonth;

    public List<SumByMonthSerieDTO> getSumProfitByMonth() {
        return sumProfitByMonth;
    }

    public void setSumProfitByMonth(List<SumByMonthSerieDTO> sumProfitByMonth) {
        this.sumProfitByMonth = sumProfitByMonth;
    }

    public List<SumByMonthSerieDTO> getSumDepenseByMonth() {
        return sumDepenseByMonth;
    }

    public void setSumDepenseByMonth(List<SumByMonthSerieDTO> sumDepenseByMonth) {
        this.sumDepenseByMonth = sumDepenseByMonth;
    }
}
