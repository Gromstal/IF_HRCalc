package org.example.hr_calc.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Result {
    private BigDecimal salaryGrossFull;
    private BigDecimal sumOfСoefficients;
    private BigDecimal salaryClearWithoutCoeffs;
    private BigDecimal salaryGrossOnlyWithRegionCoefficient;
    private BigDecimal northSup;
}
