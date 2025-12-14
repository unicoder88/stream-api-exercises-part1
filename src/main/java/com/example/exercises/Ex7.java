package com.example.exercises;

import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.List;

/**
 * Find the list of movies having the genres "Drama" and "Comedy" only
 */
public class Ex7 {
    private static final MovieService service = InMemoryMovieService.getInstance();

    List<Movie> solution1() {
        return service.findAllMovies().stream()
                .filter(movie -> {
                    List<Genre> genres = movie.getGenres();
                    return genres.size() == 2
                            && genres.stream().anyMatch(genre -> genre.getName().equals("Drama"))
                            && genres.stream().anyMatch(genre -> genre.getName().equals("Comedy"));
                }).toList();
    }
}
