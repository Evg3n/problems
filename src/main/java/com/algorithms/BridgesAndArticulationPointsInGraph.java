package com.algorithms;

import org.javatuples.Pair;

import java.util.*;


public class BridgesAndArticulationPointsInGraph {
  public static void main(String[] args) {
    int n = 9; // number of vertices
    Map<Integer, List<Integer>> g = new HashMap<>(); // graph from -> list(to)
    g.put(0, Arrays.asList(1, 2));
    g.put(1, Arrays.asList(0, 2));
    g.put(2, Arrays.asList(0, 1, 3, 5));
    g.put(3, Arrays.asList(2, 4));
    g.put(4, Arrays.asList(3));
    g.put(5, Arrays.asList(2, 6, 8));
    g.put(6, Arrays.asList(5, 7));
    g.put(7, Arrays.asList(6, 8));
    g.put(8, Arrays.asList(5, 7));

    List<Pair<Integer, Integer>> bridges = new Graph(n, g).bridges();
    List<Integer> articulationPoints = new Graph(n, g).articulationPoints();

    System.out.println("Done!");
  }
}
