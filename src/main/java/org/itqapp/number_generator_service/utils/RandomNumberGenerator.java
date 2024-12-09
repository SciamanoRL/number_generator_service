package org.itqapp.number_generator_service.utils;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("random")
@Scope("prototype")
public class RandomNumberGenerator {

    private final Random RANDOM = new Random(System.currentTimeMillis());

    public String getRandomValue() {
        return String.valueOf(10000 + RANDOM.nextLong(89999));
    }

}
