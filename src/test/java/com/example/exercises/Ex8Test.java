package com.example.exercises;

import com.example.domain.Movie;
import org.junit.jupiter.api.Test;

import java.util.*;

class Ex8Test {
    @Test
    public void testSolution1() {
        var ex = new Ex8();
        Map<Integer, List<Movie>> result = ex.solution1();
        for (Map.Entry<Integer, List<Movie>> entry : result.entrySet()) {
            System.out.printf("Year %d (%d movies):\n", entry.getKey(), entry.getValue().size());

        }
    }
}
