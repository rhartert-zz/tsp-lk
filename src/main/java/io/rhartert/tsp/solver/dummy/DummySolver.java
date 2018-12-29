package io.rhartert.tsp.solver.dummy;

import io.rhartert.tsp.solver.Solver;
import io.rhartert.tsp.util.Instance;
import io.rhartert.tsp.util.Solution;

public final class DummySolver extends Solver {

    @Override
    public Solution solve(Instance instance) {
        return new Solution(instance.getCities());
    }
}
