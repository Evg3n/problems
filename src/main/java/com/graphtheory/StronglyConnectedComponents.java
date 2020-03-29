package com.graphtheory;

import com.graphtheory.graph.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class StronglyConnectedComponents {
  public static void main(String[] args) {
    int n = 8; // number of vertices
    Map<Integer, List<Integer>> g = new HashMap<>(); // graph from -> list(to)
    g.put(0, Arrays.asList(1));
    g.put(1, Arrays.asList(2));
    g.put(2, Arrays.asList(0));
    g.put(3, Arrays.asList(4, 7));
    g.put(4, Arrays.asList(5));
    g.put(5, Arrays.asList(0, 6));
    g.put(6, Arrays.asList(0, 2, 4));
    g.put(7, Arrays.asList(3, 5));

    Integer sccCount = new Graph(n, g).sccCount();

    out.println("SCC Count: " + sccCount);
  }
}
