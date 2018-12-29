package io.rhartert.tsp.solver;

import io.rhartert.tsp.util.Instance;
import io.rhartert.tsp.util.Solution;

public abstract class Solver {

    public abstract Solution solve(Instance instance);
}
