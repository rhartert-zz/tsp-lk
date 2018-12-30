package io.rhartert.tsp.tour;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

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
    public void next_flipped() {
        Tour tour = newTour(4);
        tour.flip(3, 0);
        // {3, 1, 2, 0}
        assertEquals(tour.next(3), 1);
        assertEquals(tour.next(1), 2);
        assertEquals(tour.next(2), 0);
        assertEquals(tour.next(0), 3);
    }

    @Test
    public void prev_flipped() {
        Tour tour = newTour(4);
        tour.flip(3, 0);
        // {3, 1, 2, 0}
        assertEquals(tour.prev(3), 0);
        assertEquals(tour.prev(1), 3);
        assertEquals(tour.prev(2), 1);
        assertEquals(tour.prev(0), 2);
    }

    @Test
    public void flip() {
        assertArrayEquals(new int[]{0, 1, 2, 3}, createAndFlip(4, 0, 0));
        assertArrayEquals(new int[]{1, 0, 2, 3}, createAndFlip(4, 0, 1));
        assertArrayEquals(new int[]{2, 1, 0, 3}, createAndFlip(4, 0, 2));
        assertArrayEquals(new int[]{3, 2, 1, 0}, createAndFlip(4, 0, 3));

        assertArrayEquals(new int[]{1, 0, 3, 2}, createAndFlip(4, 1, 0));
        assertArrayEquals(new int[]{0, 1, 2, 3}, createAndFlip(4, 1, 1));
        assertArrayEquals(new int[]{0, 2, 1, 3}, createAndFlip(4, 1, 2));
        assertArrayEquals(new int[]{0, 3, 2, 1}, createAndFlip(4, 1, 3));

        assertArrayEquals(new int[]{2, 1, 0, 3}, createAndFlip(4, 2, 0));
        assertArrayEquals(new int[]{3, 2, 1, 0}, createAndFlip(4, 2, 1));
        assertArrayEquals(new int[]{0, 1, 2, 3}, createAndFlip(4, 2, 2));
        assertArrayEquals(new int[]{0, 1, 3, 2}, createAndFlip(4, 2, 3));

        assertArrayEquals(new int[]{3, 1, 2, 0}, createAndFlip(4, 3, 0));
        assertArrayEquals(new int[]{0, 3, 2, 1}, createAndFlip(4, 3, 1));
        assertArrayEquals(new int[]{1, 0, 3, 2}, createAndFlip(4, 3, 2));
        assertArrayEquals(new int[]{0, 1, 2, 3}, createAndFlip(4, 3, 3));
    }

    private int[] createAndFlip(int nCities, int a, int b) {
        Tour tour = newTour(nCities);
        tour.flip(a, b);
        return tour.toArray();
    }

    @Test
    public void flip_reflexive() {
        Tour tour = newTour(6);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j) {
                    continue;
                }
                int[] before = tour.toArray();
                tour.flip(i, j);
                tour.flip(j, i);
                int[] after = tour.toArray();

                assertArrayEquals(before, after);
            }
        }
    }
}
