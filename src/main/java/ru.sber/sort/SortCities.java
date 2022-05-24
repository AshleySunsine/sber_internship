package ru.sber.sort;

import ru.sber.model.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortCities {
   private final List<City> cities;
   private List<City> citiesSortedByName = new ArrayList<>();
   private List<City> citiesSortedByDistrict = new ArrayList<>();

    public SortCities(List<City> cities) {
        this.cities = cities;
    }

    public void sortByName() {
        citiesSortedByName = cities.stream()
                .sorted(new ComparatorCityByName())
                .collect(Collectors.toList());
    }

    public void sortByDistrictThenByName() {
        citiesSortedByDistrict = cities.stream()
                .sorted(Comparator.comparing(City::getDistrict)
                        .thenComparing(new ComparatorCityByName()))
                .collect(Collectors.toList());

    }

    public void printSortedByName() {
        if (!citiesSortedByName.isEmpty()) {
            System.out.println("Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра:");
            citiesSortedByName.forEach(System.out::println);
            System.out.println();
        } else {
            throw new RuntimeException("Сначала запустите сортировку!");
        }
    }

    public void printSortedByDistrictThenByName() {
        if (!citiesSortedByDistrict.isEmpty()) {
            System.out.println("Сортировка списка городов по федеральному округу и наименованию "
                    + System.lineSeparator() + "города внутри каждого федерального округа "
                    + System.lineSeparator() + "в алфавитном порядке по убыванию с учетом регистра:"
                    );
            citiesSortedByDistrict.forEach(System.out::println);
            System.out.println();
        } else {
            throw new RuntimeException("Сначала запустите сортировку!");
        }
    }
}
