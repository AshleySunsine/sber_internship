package ru.sber.sort;

import ru.sber.csvreader.City;

import java.util.Comparator;

public class ComparatorCityByDistrict implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return o2.getDistrict().compareTo(o1.getDistrict());
    }
}
