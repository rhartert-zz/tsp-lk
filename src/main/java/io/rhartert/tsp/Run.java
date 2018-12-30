package io.rhartert.tsp;

import io.rhartert.tsp.parser.InstanceParser;
import io.rhartert.tsp.solver.Solver;
import io.rhartert.tsp.solver.dummy.DummySolver;
import io.rhartert.tsp.solver.lk.LKSolver;
import io.rhartert.tsp.util.Instance;
import io.rhartert.tsp.util.Solution;

public class Run {

    public static void main(String[] args) {
        // Parse the instance.
        Instance instance;
        try {
            instance = InstanceParser.parse("data/tsplib/kroA1000.tsp");
        } catch (Exception e) {
            System.err.println("Error while parsing the file: " + e);
            return;
        }

        System.out.println(String.format("Instance parsed: %s cities.", instance.getCities().length));

        // Optimum = 21282.
        LKSolver solver = new LKSolver(instance, 0);
        solver.solve();
    }
}
