package io.rhartert.tsp.tour;

public class ArrayTourTest extends TourTest {

    @Override
    public Tour newTour(int nCities) {
        return new ArrayTour(nCities);
    }
}