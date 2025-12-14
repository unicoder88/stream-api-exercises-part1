package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.City;
import com.example.domain.Country;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Find the highest populated capital city of each continent
 */
public class Ex5 {
    private final WorldDao repo = InMemoryWorldDao.getInstance();

    Map<String, Optional<City>> solution1() {
        return repo.findAllCountries().stream().collect(
                Collectors.groupingBy(
                        Country::getContinent,
                        Collectors.mapping(
                                country -> repo.findCityById(country.getCapital()),
                                Collectors.filtering(
                                        Objects::nonNull,
                                        Collectors.maxBy(Comparator.comparingInt(City::getPopulation))
                                )
                        )
                )
        );
    }
}
