package io.rhartert.tsp;

import io.rhartert.tsp.parser.InstanceParser;
import io.rhartert.tsp.solver.Solver;
import io.rhartert.tsp.solver.dummy.DummySolver;
import io.rhartert.tsp.util.Instance;
import io.rhartert.tsp.util.Solution;

public class Run {

    public static void main(String[] args) {
        // Parse the instance.
        Instance instance;
        try {
            instance = InstanceParser.parse("data/cities.csv");
        } catch (Exception e) {
            System.err.println("Error while parsing the file: " + e);
            return;
        }

        // Run the solver.
        Solver solver = new DummySolver();
        Solution sol = solver.solve(instance);

        // Print the solution score.
        System.out.println("Solution score: " + sol.score());
    }
}
