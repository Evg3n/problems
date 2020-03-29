package com.graphtheory;

import com.graphtheory.graph.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class DepthFirstSearch {
  public static void main(String[] args) {
    Map<Integer, List<Integer>> g = new HashMap<>();
    g.put(0, Arrays.asList(1, 9));
    g.put(1, Arrays.asList(0, 8));
    g.put(2, Arrays.asList(3));
    g.put(3, Arrays.asList(2, 4, 5, 7));
    g.put(4, Arrays.asList(3));
    g.put(5, Arrays.asList(3, 6));
    g.put(6, Arrays.asList(5, 7));
    g.put(7, Arrays.asList(3, 6, 8, 10, 11));
    g.put(8, Arrays.asList(1, 7, 9));
    g.put(9, Arrays.asList(0, 8));
    g.put(10, Arrays.asList(7, 11));
    g.put(11, Arrays.asList(7, 10));
    g.put(12, Arrays.asList());

    List<Integer> bfs = new Graph(13, g).dfs(0);

    System.out.println("DFS: " + Arrays.toString(bfs.toArray()));
  }
}
