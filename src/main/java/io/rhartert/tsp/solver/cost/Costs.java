package io.rhartert.tsp.solver.cost;

public interface Costs {

    int nCities();

    double get(int a, int b);
}
