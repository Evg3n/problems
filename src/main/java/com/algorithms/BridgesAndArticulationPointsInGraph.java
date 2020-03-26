package com.algorithms;

import org.javatuples.Pair;

import java.util.*;

class Graph {
  private int n;
  private Map<Integer, List<Integer>> g;
  private int time; // completion time
  private int outEdgeCount;

  public Graph(int n, Map<Integer, List<Integer>> g) {
    this.n = n;
    this.g = g;
    init();
  }

  public List<Pair<Integer, Integer>> bridges() {
    init();

    List<Pair<Integer, Integer>> bridges = new ArrayList<>();

    int[] ids = new int[n];
    int[] low = new int[n];
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) dfs(i, -1, ids, low, visited, bridges);
    }

    return bridges;
  }

  public List<Integer> articulationPoints() {
    init();

    Set<Integer> articulationPoints = new HashSet<>();

    int[] ids = new int[n];
    int[] low = new int[n];
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        outEdgeCount = 0;
        dfs(i, i, -1, ids, low, visited, articulationPoints);
        if (outEdgeCount > 1) {
          articulationPoints.add(i);
        } else {
          articulationPoints.remove(i);
        }
      }
    }

    return new ArrayList<>(articulationPoints);
  }

  private void init() {
    time = -1;
  }

  private void dfs(int at, int parent, int[] ids, int[] low, boolean[] visited, List<Pair<Integer, Integer>> bridges) {
    visited[at] = true;
    time += 1;
    ids[at] = low[at] = time;

    for (Integer to : g.get(at)) {
      if (to == parent) continue;

      if (!visited[to]) {
        dfs(to, at, ids, low, visited, bridges);
        low[at] = Math.min(low[at], low[to]);
        if (ids[at] < low[to]) {
          bridges.add(Pair.with(at, to));
        }
      } else {
        low[at] = Math.min(low[at], low[to]);
      }
    }
  }

  private void dfs(int root, int at, int parent, int[] ids, int[] low, boolean[] visited, Set<Integer> articulationPoints) {
    if (parent == root) outEdgeCount++;
    visited[at] = true;
    time += 1;
    ids[at] = low[at] = time;

    for (Integer to : g.get(at)) {
      if (to == parent) continue;

      if (!visited[to]) {
        dfs(to, to, at, ids, low, visited, articulationPoints);
        low[at] = Math.min(low[at], low[to]);
        // point found via bridge
        if (ids[at] < low[to]) {
          articulationPoints.add(at);
        } else if (ids[at] == low[to]) { // point found via cycle
          articulationPoints.add(at);
        }
      } else {
        low[at] = Math.min(low[at], low[to]);
      }
    }
  }
}

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
