package org.itqapp.number_generator_service.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("numberList")
public class ListForNumbers {

    private final ArrayList<String> numberList = new ArrayList<>();


    public void addNumberToList(String number) {
        numberList.add(number);
    }

    public boolean isContains(String number) {
        return numberList.contains(number);
    }
}
