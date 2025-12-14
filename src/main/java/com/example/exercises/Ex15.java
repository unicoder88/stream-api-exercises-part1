package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Group the countries by continent, and then sort the countries in continent by number of cities
 * in each continent.
 */
public class Ex15 {
    private final WorldDao repo = InMemoryWorldDao.getInstance();

    Map<String, List<Country>> solution1() {
        return repo.findAllCountries().stream().collect(Collectors.groupingBy(
                Country::getContinent,
                TreeMap::new, // sort continents by name
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            list.sort(Comparator.comparingInt(country -> -country.getCities().size()));
                            return list;
                        }
                )
        ));
    }
}
