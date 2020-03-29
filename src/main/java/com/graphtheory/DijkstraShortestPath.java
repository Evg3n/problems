package com.graphtheory;

import com.graphtheory.graph.WeightedGraph;
import org.javatuples.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class DijkstraShortestPath {
  public static void main(String[] args) {
    Map<Integer, List<Pair<Integer, Integer>>> g = new HashMap<>();
    g.put(0, Arrays.asList(Pair.with(1, 4), Pair.with(2, 1)));
    g.put(1, Arrays.asList(Pair.with(3, 1)));
    g.put(2, Arrays.asList(Pair.with(1, 2), Pair.with(3, 5)));
    g.put(3, Arrays.asList(Pair.with(4, 3)));
    g.put(4, Arrays.asList());

    int pathLength = new WeightedGraph(5, g).dijkstra(0, 4);

    out.println("Shortest Path Length: " + pathLength);
  }
}
