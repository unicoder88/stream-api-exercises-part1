package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.Comparator;
import java.util.List;

/**
 * Sort the countries by number of their cities in descending order
 */
public class Ex6 {
    private final WorldDao repo = InMemoryWorldDao.getInstance();

    List<Country> solution1() {
        return repo.findAllCountries().stream().sorted(
                Comparator.comparingInt(
                        country -> -country.getCities().size()
                )
        ).toList();
    }
}
