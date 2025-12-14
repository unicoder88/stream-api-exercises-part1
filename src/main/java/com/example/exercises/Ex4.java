package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.City;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

/**
 * Find the highest populated capital city
 */
public class Ex4 {
    private final WorldDao repo = InMemoryWorldDao.getInstance();

    Optional<City> solution1() {
        // country.capital -> city.id
        return repo.findAllCountries().stream()
                .map(country -> repo.findCityById(country.getCapital()))
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(City::getPopulation));
    }
}
