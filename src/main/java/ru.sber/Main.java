package ru.sber;

import ru.sber.model.City;
import ru.sber.csvreader.CsvReader;
import ru.sber.search.Searcher;
import ru.sber.searchRegions.SearchRegions;
import ru.sber.sort.SortCities;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       CsvReader cityParser = new CsvReader();
        List<City> cities = cityParser.parse("data/city_ru.csv");
     //   cityParser.printList(cities);

     /*   SortCities sortCities = new SortCities(cities);
        sortCities.sortByName();
        sortCities.sortByDistrictThenByName();
        sortCities.printSortedByName();
        sortCities.printSortedByDistrictThenByName();

        Searcher searcher = new Searcher();
        City cityMaxPopulation = searcher.search(cities);
        System.out.println("Город с максимальным населением: ");
        System.out.println("[" + cityMaxPopulation.getId() + "] = " + cityMaxPopulation.getPopulation());*/

        SearchRegions searchRegions = new SearchRegions();
        searchRegions.search(cities);

    }

}
