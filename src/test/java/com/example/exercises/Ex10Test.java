package com.example.exercises;

import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

class Ex10Test {
    @Test
    public void testSolution1() {
        var ex = new Ex10();
        Map<String, Optional<Country>> result = ex.solution1();
        result.forEach((continent, country) -> {
            System.out.printf("%s: %s (%d)\n",
                    continent,
                    country.map(Country::getName).orElse("N/A"),
                    country.map(Country::getPopulation).orElse(0)
            );
        });
    }
}
