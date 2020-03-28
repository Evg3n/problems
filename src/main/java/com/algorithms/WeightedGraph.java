package com.algorithms;

import org.javatuples.Pair;

import java.util.*;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class WeightedGraph {
  private int n;
  // at -> list of (to, weight)
  private Map<Integer, List<Pair<Integer, Integer>>> g;

  public WeightedGraph(int n, Map<Integer, List<Pair<Integer, Integer>>> g) {
    this.n = n;
    this.g = g;
  }

  public int dijkstra(int start, int target) {
    if (start < 0 || target >= n) {
      return Integer.MAX_VALUE;
    }

    int[] distance = new int[n];
    Arrays.fill(distance, Integer.MAX_VALUE);

    Queue<Pair<Integer, Integer>> nextUp = new PriorityQueue<>(Comparator.comparing(Pair::getValue1));
    nextUp.add(Pair.with(start, 0));
    distance[start] = 0;

    while (!nextUp.isEmpty()) {
      Pair<Integer, Integer> atPair = nextUp.poll();
      int at = atPair.getValue0();
      int weight = atPair.getValue1();

      distance[at] = Math.min(distance[at], weight);

      for (Pair<Integer, Integer> toPair : g.get(atPair.getValue0())) {
        nextUp.add(Pair.with(toPair.getValue0(), toPair.getValue1() + distance[at]));
      }

      if (at == target) {
        return distance[target];
      }
    }

    return Integer.MAX_VALUE;
  }
}
