package com.example.exercises;

import com.example.domain.Director;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find the number of movies of each director
 */
public class Ex1 {
    public Map<Director, Integer> solution1() {
        MovieService service = InMemoryMovieService.getInstance();

        return service.findAllMovies()
                .stream()
                .flatMap(movie -> movie.getDirectors().stream())
                .collect(Collectors.groupingBy(
                        director -> director,
                        Collectors.summingInt(director -> 1)
                ));
    }

    public Map<String, Long> solution2() {
        MovieService service = InMemoryMovieService.getInstance();

        return service.findAllMovies()
                .stream()
                .flatMap(movie -> movie.getDirectors().stream())
                .collect(Collectors.groupingBy(
                        Director::getName,
                        Collectors.counting()
                ));
    }
}
