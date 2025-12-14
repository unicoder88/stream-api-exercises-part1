package com.example.exercises;

import com.example.domain.*;
import org.junit.jupiter.api.Test;

import java.util.*;

class Ex11Test {
    @Test
    public void testSolution1() {
        var ex = new Ex11();
        IntSummaryStatistics result = ex.solution1();
        System.out.printf("Min: %d, max: %d, avg: %f\n",
                result.getMin(),
                result.getMax(),
                result.getAverage()
        );
    }
}
