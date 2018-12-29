package io.rhartert.tsp.parser;

import io.rhartert.tsp.util.City;
import io.rhartert.tsp.util.Instance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class InstanceParser {

    public static Instance parse(String inputFile) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader(inputFile));

        ArrayList<City> cities = new ArrayList<>();

        input.readLine(); // drop first line.

        String line;
        while ((line = input.readLine()) != null) {
            String[] data = line.split(",");
            int id = Integer.parseInt(data[0]);
            double x = Double.parseDouble(data[1]);
            double y = Double.parseDouble(data[2]);
            cities.add(new City(id, x, y));
        }

        return new Instance(cities);
    }
}
