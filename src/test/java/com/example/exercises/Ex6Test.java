package com.example.exercises;

import com.example.domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;

class Ex6Test {
    @Test
    public void testSolution1() {
        var solver = new Ex6();
        List<Country> result = solver.solution1();
        System.out.println(result);
    }
}
