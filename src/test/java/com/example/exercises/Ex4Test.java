package com.example.exercises;

import com.example.domain.City;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Ex4Test {
    @Test
    public void testSolution1() {
        var ex4 = new Ex4();
        Optional<City> result = ex4.solution1();
        assertTrue(result.isPresent());
        System.out.println(result.get());
    }
}
