package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Find the minimum, the maximum and the average population of each continent.
 */
public class Ex12 {
    private final WorldDao repo = InMemoryWorldDao.getInstance();

    Map<String, IntSummaryStatistics> solution1() {
        return repo.findAllCountries().stream()
                .filter(country -> country.getPopulation() > 0)
                .collect(
                        Collectors.groupingBy(
                                Country::getContinent,
                                TreeMap::new,
                                Collectors.summarizingInt(Country::getPopulation)
                        )
                );
    }
}
