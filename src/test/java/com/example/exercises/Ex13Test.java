package com.example.exercises;

import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.*;

class Ex13Test {
    @Test
    public void testSolution1() {
        var ex = new Ex13();
        Map<Boolean, List<Country>> result = ex.solution1();
        result.forEach((isMin, countries) -> {
            if (isMin) {
                System.out.println("Min population: ");
            } else {
                System.out.println("Max population: ");
            }

            countries.forEach(country -> {
                System.out.printf("- %s (%d)\n", country.getName(), country.getPopulation());
            });
        });
    }
}
