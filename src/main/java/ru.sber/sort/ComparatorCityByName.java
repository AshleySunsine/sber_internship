package ru.sber.sort;

import ru.sber.csvreader.City;

import java.util.Comparator;

public class ComparatorCityByName implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
