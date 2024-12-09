package org.itqapp.number_generator_service.service;

import org.itqapp.number_generator_service.utils.ListForNumbers;
import org.itqapp.number_generator_service.utils.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class NumberGeneratorServiceImpl implements NumberGeneratorService{

    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public String generateNumber() {
        String generatedNumber = concatNumberAndDate();
        ListForNumbers listForNumbers = applicationContext.getBean("numberList", ListForNumbers.class);
        if (listForNumbers.isContains(generatedNumber)) {
            generatedNumber = concatNumberAndDate();
        } else {
            listForNumbers.addNumberToList(generatedNumber);
        }
        return generatedNumber;
    }

    private String concatNumberAndDate() {
        LocalDate date = LocalDate.now();
        return applicationContext.getBean("random", RandomNumberGenerator.class)
                .getRandomValue() + DATE_TIME_FORMATTER.format(date);
    }
}
