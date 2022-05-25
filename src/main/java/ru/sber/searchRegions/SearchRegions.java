package ru.sber.searchRegions;

import ru.sber.model.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchRegions {
    public void search(List<City> cities) {
        Map<String, List<City>> map = new HashMap<>();
        for (var c : cities) {
            if (c.getRegion() != null) {
                if (map.containsKey(c.getRegion())) {
                    map.get(c.getRegion()).add(c);
                } else {
                    List<City> cityList = new ArrayList<>();
                    cityList.add(c);
                    map.put(c.getRegion(), cityList);
                }
            }
        }
        System.out.println(map.entrySet().size());
        //return cities.get(idMaxCity);
    }
}
