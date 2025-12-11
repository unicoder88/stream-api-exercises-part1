package com.example.exercises;

import org.junit.jupiter.api.Test;

import java.util.Map;
import com.example.domain.Director;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex1Test {
    @Test
    public void testSolution1() {
        var ex1 = new Ex1();
        Map<Director, Integer> map = ex1.solution1();

        System.out.println(map);

        assertEquals(2, map.get(new Director().setId(51)));
    }

    @Test
    public void testSolution2() {
        var ex1 = new Ex1();
        Map<String, Long> map = ex1.solution2();
        map.forEach((name, count) -> {
            System.out.printf("%s: %d%n", name, count);
        });

        assertEquals(2, map.get("Grant Heslov"));
    }
}
