package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sort the countries by their population densities in descending order ignoring zero population
 * countries
 */
public class Ex9 {
    private final WorldDao repo = InMemoryWorldDao.getInstance();

    List<Country> solution1() {
        return repo.findAllCountries().stream()
                .filter(country -> country.getPopulation() > 0)
                .sorted(Collections.reverseOrder(Comparator.comparingInt(Country::getPopulation)))
                .toList();
    }
}
