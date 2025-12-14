package com.example.exercises;

import com.example.domain.Movie;
import org.junit.jupiter.api.Test;

import java.util.List;

class Ex7Test {
    @Test
    public void testSolution1() {
        var ex = new Ex7();
        List<Movie> result = ex.solution1();
        System.out.println(result);
    }
}
