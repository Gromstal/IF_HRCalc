package org.example.hr_calc.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestSum {

    private BigDecimal salaryNet;


    private BigDecimal regionCoefficient;


    private BigDecimal northCoefficient;
}
