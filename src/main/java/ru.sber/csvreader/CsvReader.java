package ru.sber.csvreader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {

    public List<City> parse(String file) {
        validate(file);
        File fileIn = new File(file);
        List<City> cityList = new ArrayList<>();
        try (Scanner scanner = new Scanner(fileIn)) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(";", 6);
                    City city = new City();
                    city.setId(Long.parseLong(line[0]));
                    city.setName(line[1]);
                    city.setRegion(line[2]);
                    city.setDistrict(line[3]);
                    city.setPopulation(Long.parseLong(line[4]));
                    city.setFoundation(line[5]);
                    cityList.add(city);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return cityList;
    }

    public void printList(List<City> cities) {
        cities.forEach(System.out::println);
    }

    private void validate(String file) {
        File fileIn = Paths.get(file).toFile();
        if (!fileIn.exists()) {
            throw new IllegalArgumentException(
                    String.format("Not exist %s", fileIn.getAbsoluteFile()));
        }
    }
}
