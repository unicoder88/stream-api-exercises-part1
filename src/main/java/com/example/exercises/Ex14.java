package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.*;
import java.util.stream.*;

/**
 * Find the countries of each continent with the minimum and the maximum population.
 */
public class Ex14 {
    private final WorldDao repo = InMemoryWorldDao.getInstance();

    Map<String, Map<Boolean, List<Country>>> solution1() {
        // hash map result
        Map<String, Map<Boolean, List<Country>>> map = repo.getAllContinents().stream().collect(Collectors.toMap(
                continent -> continent,
                continent -> {
                    List<Country> countries = repo.findCountriesByContinent(continent);

                    IntSummaryStatistics stats = countries.stream()
                            .filter(country -> country.getPopulation() > 0)
                            .collect(Collectors.summarizingInt(Country::getPopulation));

                    return countries.stream()
                            .filter(country -> country.getPopulation() == stats.getMin() || country.getPopulation() == stats.getMax())
                            .collect(Collectors.partitioningBy(
                                    country -> country.getPopulation() == stats.getMin()
                            ));
                }
        ));
        // sort by continent name
        return new TreeMap<>(map);
    }
}
