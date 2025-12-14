package com.example.exercises;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Group the movies by the year and list them
 */
public class Ex8 {
    private static final MovieService service = InMemoryMovieService.getInstance();

    Map<Integer, List<Movie>> solution1() {
        return service.findAllMovies().stream().collect(
                Collectors.groupingBy(
                        Movie::getYear,
                        () -> new TreeMap<>(Comparator.comparingInt(value -> -value)),
                        Collectors.toList()
                )
        );
    }
}
