package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.*;
import java.util.stream.*;

/**
 * Find the countries with the minimum and the maximum population.
 */
public class Ex13 {
    private final WorldDao repo = InMemoryWorldDao.getInstance();

    Map<Boolean, List<Country>> solution1() {
        List<Country> countries = repo.findAllCountries();
        IntSummaryStatistics stats = countries.stream()
                .filter(country -> country.getPopulation() > 0)
                .collect(Collectors.summarizingInt(Country::getPopulation));

        return countries.stream()
                .filter(country -> country.getPopulation() == stats.getMin() || country.getPopulation() == stats.getMax())
                .collect(Collectors.partitioningBy(
                        country -> country.getPopulation() == stats.getMin()
                ));
    }
}
