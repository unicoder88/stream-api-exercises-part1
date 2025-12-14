package com.example.exercises;

import com.example.domain.City;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Ex5Test {
    @Test
    public void testSolution1() {
        var ex5 = new Ex5();
        Map<String, Optional<City>> result = ex5.solution1();
        System.out.println(result);
    }
}
