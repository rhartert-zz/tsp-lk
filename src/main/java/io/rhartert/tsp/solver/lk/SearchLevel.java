package io.rhartert.tsp.solver.lk;

import io.rhartert.tsp.solver.cost.Costs;
import io.rhartert.tsp.tour.Tour;
import io.rhartert.tsp.util.TupleInt;

public class SearchLevel {
    public final int level;
    public final int base;
    public final double delta;

    private TupleInt lastFlip = null;

    private LKOrdering lkOrdering;

    public SearchLevel(Tour tour, Costs costs, int level, int base, double delta) {
        this.level = level;
        this.base = base;
        this.delta = delta;
        this.lkOrdering = new LKOrdering(base, tour, costs, 5);
    }

    public LKOrdering getLkOrdering() {
        return lkOrdering;
    }

    public void setLastFlip(int a, int b) {
        lastFlip = new TupleInt(a, b);
    }

    public TupleInt getLastFlip() {
        return lastFlip;
    }

    public boolean hasLastFlip() {
        return lastFlip != null;
    }
}
