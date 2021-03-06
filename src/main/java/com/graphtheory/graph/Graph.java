package com.graphtheory.graph;

import org.javatuples.Pair;

import java.util.*;

public class Graph {
  private static final int UNVISITED = -1;
  private int n;
  private Map<Integer, List<Integer>> g;
  private int time; // completion time
  private int outEdgeCount;
  private int sccCount;

  public Graph(int n, Map<Integer, List<Integer>> g) {
    this.n = n;
    this.g = g;
    init();
  }

  public List<Integer> dfs(int start) {
    List<Integer> result = new ArrayList<>();

    if (start < 0 || start >= n) {
      return result;
    }

    boolean[] visited = new boolean[n];
    dfsHelper(start, visited, result);

    return result;
  }

  private void dfsHelper(int at, boolean[] visited, List<Integer> result) {
    if (visited[at]) {
      return;
    }

    visited[at] = true;
    result.add(at);
    for (Integer to : g.get(at)) {
      dfsHelper(to, visited, result);
    }
  }

  public List<Integer> bfs(int start) {
    List<Integer> result = new ArrayList<>();

    if (start < 0 || start >= n) {
      return result;
    }

    boolean[] visited = new boolean[n];
    Queue<Integer> next = new LinkedList<>();
    next.add(start);

    while (!next.isEmpty()) {
      Integer at = next.poll();

      if (visited[at]) {
        continue;
      }

      visited[at] = true;
      result.add(at);

      for (Integer to : g.get(at)) {
        if (!visited[to]) {
          next.add(to);
        }
      }
    }

    return result;
  }

  public List<Pair<Integer, Integer>> bridges() {
    init();

    List<Pair<Integer, Integer>> bridges = new ArrayList<>();

    int[] ids = new int[n];
    int[] low = new int[n];
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        bridgesDfs(i, -1, ids, low, visited, bridges);
      }
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
        articulationPointsDfs(i, i, -1, ids, low, visited, articulationPoints);
        if (outEdgeCount > 1) {
          articulationPoints.add(i);
        } else {
          articulationPoints.remove(i);
        }
      }
    }

    return new ArrayList<>(articulationPoints);
  }

  public Integer sccCount() {
    init();

    int[] ids = new int[n];
    int[] low = new int[n];
    boolean[] onStack = new boolean[n];
    Stack<Integer> stack = new Stack<>();

    Arrays.fill(ids, UNVISITED);

    for (int i = 0; i < ids.length; i++) {
      if (ids[i] == UNVISITED) {
        sccDfs(i, ids, low, onStack, stack);
      }
    }

    return sccCount;
  }

  public List<Integer> topSort() {
    boolean[] visited = new boolean[n];
    List<Integer> order = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        topSortDfs(i, visited, order);
        order.add(0, i);
      }
    }

    return order;
  }

  private void init() {
    time = -1;
  }

  private void bridgesDfs(
    int at,
    int parent,
    int[] ids,
    int[] low,
    boolean[] visited,
    List<Pair<Integer, Integer>> bridges
  ) {
    visited[at] = true;
    time += 1;
    ids[at] = low[at] = time;

    for (Integer to : g.get(at)) {
      if (to == parent) {
        continue;
      }

      if (!visited[to]) {
        bridgesDfs(to, at, ids, low, visited, bridges);
        low[at] = Math.min(low[at], low[to]);
        if (ids[at] < low[to]) {
          bridges.add(Pair.with(at, to));
        }
      } else {
        low[at] = Math.min(low[at], low[to]);
      }
    }
  }

  private void articulationPointsDfs(
    int root,
    int at,
    int parent,
    int[] ids,
    int[] low,
    boolean[] visited,
    Set<Integer> articulationPoints
  ) {
    if (parent == root) {
      outEdgeCount++;
    }
    visited[at] = true;
    time += 1;
    ids[at] = low[at] = time;

    for (Integer to : g.get(at)) {
      if (to == parent) {
        continue;
      }

      if (!visited[to]) {
        articulationPointsDfs(to, to, at, ids, low, visited, articulationPoints);
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

  private void sccDfs(
    int at,
    int[] ids,
    int[] low,
    boolean[] onStack,
    Stack<Integer> stack
  ) {
    stack.push(at);
    onStack[at] = true;
    time++;
    ids[at] = low[at] = time;

    for (Integer to : g.get(at)) {
      if (ids[to] == UNVISITED) {
        sccDfs(to, ids, low, onStack, stack);
      }
      if (onStack[to]) {
        low[at] = Math.min(low[at], low[to]);
      }
    }

    if (ids[at] == low[at]) {
      while (!stack.isEmpty()) {
        Integer node = stack.pop();
        onStack[node] = false;
//        low[node] = ids[at];
        if (node == at) {
          break;
        }
      }
      sccCount++;
    }
  }

  private void topSortDfs(int at, boolean[] visited, List<Integer> order) {
    visited[at] = true;
    for (Integer to : g.get(at)) {
      if (!visited[to]) {
        topSortDfs(to, visited, order);
        order.add(0, to);
      }
    }
  }
}
