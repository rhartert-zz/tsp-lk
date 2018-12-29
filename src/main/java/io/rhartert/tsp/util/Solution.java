package io.rhartert.tsp.util;

public final class Solution {

    private final City[] path;

    public Solution(City[] path) {
        this.path = path;
    }

    public double score() {
        double totalDistance = 0;
        for (int i = 0; i < path.length - 1; i++) {
            totalDistance += path[i].distanceTo(path[i+1]);
        }
        totalDistance += path[path.length - 1].distanceTo(path[0]);
        return totalDistance;
    }

    @Override
    public String toString() {
        return "";
    }
}
