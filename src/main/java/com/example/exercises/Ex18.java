package com.example.exercises;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Find the year where the maximum number of movie is available
 */
public class Ex18 {
    private static final MovieService service = InMemoryMovieService.getInstance();

    Integer solution1() {
        Map<Integer, Long> yearToCountMovies = service.findAllMovies().stream().collect(Collectors.groupingBy(
                Movie::getYear,
                TreeMap::new,
                Collectors.counting()
        ));

        yearToCountMovies.forEach((year, countMovies) -> {
            System.out.printf("year %d: %d movies\n", year, countMovies);
        });

        return yearToCountMovies.keySet().stream().max(Comparator.comparingLong(yearToCountMovies::get)).get();
    }
}
