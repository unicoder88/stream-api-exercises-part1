package com.example.exercises;

import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.*;

class Ex15Test {
    @Test
    public void testSolution1() {
        var ex = new Ex15();
        Map<String, List<Country>> result = ex.solution1();
        result.forEach((continent, countries) -> {
            System.out.println(continent + ":");

            countries.forEach(country -> {
                System.out.printf("  - %s (%d cities)\n", country.getName(), country.getCities().size());
            });
        });
    }
}
