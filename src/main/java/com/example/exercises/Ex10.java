package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Find the richest country of each continent with respect to their GNP (Gross National Product)
 * values.
 */
public class Ex10 {
    private final WorldDao repo = InMemoryWorldDao.getInstance();

    Map<String, Optional<Country>> solution1() {
        return repo.findAllCountries().stream().collect(
                Collectors.groupingBy(
                        Country::getContinent,
                        Collectors.maxBy(Comparator.comparingDouble(Country::getGnp))
                )
        );
    }
}
