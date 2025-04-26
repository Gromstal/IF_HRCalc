package org.example.hr_calc.service;

import org.example.hr_calc.dto.RequestSum;
import org.example.hr_calc.dto.Result;

import java.math.BigDecimal;

public interface CalculateService {
    Result calculate(RequestSum requestSum);
}
