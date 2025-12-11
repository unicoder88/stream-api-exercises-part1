package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.City;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Set;

/**
 * Find the most populated city of each continent
 */
public class Ex2 {
    public Map<String, Optional<City>> solution1() {
        WorldDao repo = InMemoryWorldDao.getInstance();

        // city.countryCode -> country = repo.findCountryByCode -> country.continent
        List<City> cities = repo.findAllCities();
        return cities.stream().collect(Collectors.groupingBy(
                city -> repo.findCountryByCode(city.getCountryCode()).getContinent(),
                Collectors.maxBy(Comparator.comparingInt(City::getPopulation))
        ));
    }

    /**
     * continent name -> city name
     */
    Map<String, String> solution2() {
        WorldDao repo = InMemoryWorldDao.getInstance();

        // continent[] -> repo.findCountriesByContinent(n)[] -> repo.findCitiesByCountryCode().population
        Set<String> continents = repo.getAllContinents();

        return continents.stream().collect(Collectors.toMap(
                continent -> continent,
                continent -> repo.findCountriesByContinent(continent).stream()
                        .flatMap(country -> repo.findCitiesByCountryCode(country.getCode()).stream())
                        .max(Comparator.comparingInt(City::getPopulation))
//                        .collect(Collectors.maxBy(Comparator.comparingInt(City::getPopulation)))
                        .map(City::getName)
                        .orElse("N/A")
        ));
    }
}
