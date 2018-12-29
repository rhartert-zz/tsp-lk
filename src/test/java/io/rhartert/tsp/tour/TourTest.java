package io.rhartert.tsp.tour;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class TourTest {

    public abstract Tour newTour(int nCities);

    @Test
    public void next_middleCity() {
        Tour tour = newTour(5);
        assertEquals(tour.next(3), 4);
    }

    @Test
    public void next_lastCity() {
        Tour tour = newTour(5);
        assertEquals(tour.next(4), 0);
    }

    @Test
    public void prev_middleCity() {
        Tour tour = newTour(5);
        assertEquals(tour.prev(3), 2);
    }

    @Test
    public void prev_firstCity() {
        Tour tour = newTour(5);
        assertEquals(tour.prev(0), 4);
    }

    @Test
    public void flip() {
        Tour tour = newTour(5);
    }
}
