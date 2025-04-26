package org.example.hr_calc.controller;

import lombok.RequiredArgsConstructor;
import org.example.hr_calc.dto.RequestSum;
import org.example.hr_calc.dto.Result;
import org.example.hr_calc.service.CalculateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class CaclController {

    private final CalculateService calculateService;


    @GetMapping
    public String getCalcPage(Model model){
        model.addAttribute("requestSum", new RequestSum());
        return "homePage";
    }

    @PostMapping
    public String calculate(@ModelAttribute RequestSum requestSum, Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "homePage";
        }
        Result result =calculateService.calculate(requestSum);
        model.addAttribute("result", result);

        return "homePage";
    }
}
