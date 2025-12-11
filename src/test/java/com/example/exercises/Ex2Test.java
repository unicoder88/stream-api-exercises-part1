package com.example.exercises;

import com.example.domain.City;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {
    @Test
    public void testSolution1() {
        var ex2 = new Ex2();
        Map<String, Optional<City>> result = ex2.solution1();

        result.forEach((continent, city) -> {
           System.out.printf("%s: %s (%d)%n",
                   continent,
                   city.map(City::getName).orElse("N/A"),
                   city.map(City::getPopulation).orElse(0)
           );
        });
        assertEquals("Moscow", result.get("Europe").map(City::getName).orElse("N/A"));
    }

    @Test
    public void testSolution2() {
        var ex2 = new Ex2();
        Map<String, String> result = ex2.solution2();

        result.forEach((continent, city) -> {
            System.out.printf("%s: %s%n",
                    continent,
                    city
            );
        });
        assertEquals("Moscow", result.get("Europe"));
    }
}
