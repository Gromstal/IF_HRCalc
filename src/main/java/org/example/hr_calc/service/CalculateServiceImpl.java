package org.example.hr_calc.service;

import org.example.hr_calc.dto.RequestSum;
import org.example.hr_calc.dto.Result;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public Result calculate(RequestSum requestSum) {
        BigDecimal divisor = new BigDecimal("0.87");

        Result result = new Result();

        result.setSalaryGrossFull( //оклад гросс со всеми надбавками
                requestSum.getSalaryNet()
                        .divide(divisor, 0, RoundingMode.CEILING));

        result.setSumOfСoefficients( //сумма всех коэффициентов и надбавок
                requestSum.getRegionCoefficient().add(requestSum.getNorthCoefficient()));


        result.setSalaryClearWithoutCoeffs(  // оклад гросс без надбавок
                result.getSalaryGrossFull()
                        .divide(result.getSumOfСoefficients(), 0, RoundingMode.UP));


        result.setSalaryGrossOnlyWithRegionCoefficient( // оклад гросс с райнным коэффициентом
                result.getSalaryClearWithoutCoeffs()
                        .multiply(requestSum.getRegionCoefficient()));


        result.setNorthSup( //северная надбавка
                result.getSalaryGrossFull().subtract(result.getSalaryGrossOnlyWithRegionCoefficient()));

        return result;
    }
}
