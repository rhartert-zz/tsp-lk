package io.rhartert.tsp.solver.dummy;

import io.rhartert.tsp.solver.Solver;
import io.rhartert.tsp.util.Instance;
import io.rhartert.tsp.util.Solution;

public final class DummySolver extends Solver {

    private final Instance instance;

    public DummySolver(Instance instance) {
        this.instance = instance;
    }

    @Override
    public Solution solve() {
        return new Solution(instance.getCities());
    }
}
