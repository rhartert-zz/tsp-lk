package io.rhartert.tsp.util;

public class City {

    private final boolean isPrime;

    public final int id;
    public final double x;
    public final double y;

    public City(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.isPrime = isPrime(id);
    }

    public boolean isPrime() {
        return isPrime;
    }

    public double distanceTo(City that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    private static boolean isPrime(int n) {
        for (int i = 2; 2 * i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
