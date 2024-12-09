package org.itqapp.number_generator_service.controller;

import org.itqapp.number_generator_service.service.NumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberGeneratorController {

    NumberGeneratorService numberGeneratorService;

    @Autowired
    public NumberGeneratorController(NumberGeneratorService numberGeneratorService) {
        this.numberGeneratorService = numberGeneratorService;
    }

    @GetMapping("/numbers")
    public String generateRandomNumber() {
        return numberGeneratorService.generateNumber();
    }
}
