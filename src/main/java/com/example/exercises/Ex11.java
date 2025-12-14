package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Find the minimum, the maximum and the average population of world countries.
 */
public class Ex11 {
    private final WorldDao repo = InMemoryWorldDao.getInstance();

     IntSummaryStatistics solution1() {
        return repo.findAllCountries().stream()
                .filter(country -> country.getPopulation() > 0)
                .collect(Collectors.summarizingInt(Country::getPopulation));
    }
}
