package com.graphtheory;

import com.graphtheory.graph.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class TopSort {
  public static void main(String[] args) {
    int n = 11; // number of vertices
    Map<Integer, List<Integer>> g = new HashMap<>(); // graph from -> list(to)
    g.put(0, Arrays.asList(1, 2, 3));
    g.put(1, Arrays.asList(4));
    g.put(2, Arrays.asList(5, 6));
    g.put(3, Arrays.asList(7, 8));
    g.put(4, Arrays.asList());
    g.put(5, Arrays.asList());
    g.put(6, Arrays.asList());
    g.put(7, Arrays.asList());
    g.put(8, Arrays.asList(9, 10));
    g.put(9, Arrays.asList());
    g.put(10, Arrays.asList());

    List<Integer> topSort = new Graph(n, g).topSort();

    System.out.println(Arrays.toString(topSort.toArray()));
  }
}
