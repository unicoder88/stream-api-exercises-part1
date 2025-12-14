package com.example.exercises;

import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;

class Ex9Test {
    @Test
    public void testSolution1() {
        var ex = new Ex9();
        List<Country> result = ex.solution1();
        System.out.println(result);
    }
}
