package com.example.exercises;

import org.junit.jupiter.api.Test;

import java.util.*;

class Ex12Test {
    @Test
    public void testSolution1() {
        var ex = new Ex12();
        Map<String, IntSummaryStatistics> result = ex.solution1();
        result.forEach((continent, stats) -> {
            System.out.printf("%s - min: %d, max: %d, avg: %f\n",
                    continent,
                    stats.getMin(),
                    stats.getMax(),
                    stats.getAverage()
            );
        });
    }
}
