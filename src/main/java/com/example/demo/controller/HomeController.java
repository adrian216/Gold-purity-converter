package com.example.demo.controller;

import com.example.demo.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    GoldService goldService;


    @GetMapping("/")
    public ModelAndView getCalculateView() {
        return new ModelAndView("/form");
    }

    @PostMapping("/calculate")
    public String calculate(Model model,
                                  @RequestParam Double weight,
                                  @RequestParam Double karat) {
        List<String> resultList = goldService.calculate(weight, karat);
        model.addAttribute("resultList", resultList);
       return "result-form";
    }


}
