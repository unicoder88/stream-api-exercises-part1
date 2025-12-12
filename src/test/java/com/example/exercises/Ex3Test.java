package com.example.exercises;

import com.example.domain.Director;
import com.example.domain.Genre;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Ex3Test {
    @Test
    public void testSolution1() {
        var ex = new Ex3();
        Map<Director, Set<Genre>> result = ex.solution1();
        result.forEach((director, genres) -> {
            System.out.println(director + ": " + genres);
        });
    }
}
