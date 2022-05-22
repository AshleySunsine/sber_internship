package ru.sber;

import ru.sber.csvreader.City;
import ru.sber.csvreader.CsvReader;
import ru.sber.sort.SortCities;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvReader cityParser = new CsvReader();
        List<City> cities = cityParser.parse("data/city_ru.csv");
        cityParser.printList(cities);

        SortCities sortCities = new SortCities(cities);
        sortCities.sortByName();
        sortCities.sortByDistrictThenByName();
        sortCities.printSortedByName();
        sortCities.printSortedByDistrictThenByName();
    }

}
