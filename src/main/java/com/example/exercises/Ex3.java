package com.example.exercises;

import com.example.domain.Director;
import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find the number of genres of each director's movies
 */
public class Ex3 {
    record DirectorWithGenres(
            Director director,
            Set<Genre> genres
    ) {
    }

    Map<Director, Set<Genre>> solution1() {
        MovieService service = InMemoryMovieService.getInstance();

        Collection<Movie> movies = service.findAllMovies();

        // movie -> directors[] = genres[]
        //   each director has all genres

        // movie1 - [director1, director2], [genreA, genreB, genreC]
        //   director1 -> [genreA, genreB, genreC]
        //   director2 -> [genreA, genreB, genreC]
        // movie2 - [director1, director9], [genreD]
        //   director1 -> [genreD]
        //   director9 -> [genreD]

        //   record: director1, [genreA, genreB, genreC]
        //   record: director2, [genreA, genreB, genreC]
        //   record: director1, [genreD]
        //   record: director9, [genreD]

        return movies.stream().flatMap(
                        movie -> movie.getDirectors().stream().map(
                                director -> new DirectorWithGenres(director, new LinkedHashSet<>(movie.getGenres()))
                        ))
                .collect(Collectors.toMap(
                        DirectorWithGenres::director,
                        DirectorWithGenres::genres,
                        (oldValue, newValue) -> {
                            oldValue.addAll(newValue);
                            return oldValue;
                        }
                ));
    }
}
