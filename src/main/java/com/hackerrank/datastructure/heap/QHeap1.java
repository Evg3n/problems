package com.hackerrank.datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/qheap1/problem
 */
public class QHeap1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(QHeap1.class.getClassLoader().getResourceAsStream(
      "hackerrank/datastructure/heap/q_heap_1.txt"));

    int commandsCount = in.nextInt();
    in.nextLine();

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < commandsCount; i++) {
      String command = in.nextLine();

      Integer[] parts;
      parts = Arrays.stream(command.split(" ")).map(Integer::valueOf)
        .collect(Collectors.toList()).toArray(new Integer[0]);

      switch (parts[0]) {
        case 1:
          queue.add(parts[1]);
          break;
        case 2:
          queue.remove(parts[1]);
          break;
        case 3:
          System.out.println(queue.peek());
          break;
      }
    }
  }
}