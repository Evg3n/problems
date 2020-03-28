package com.hackerrank.datastructure.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-the-running-median/
 */
public class FindTheRunningMedian {
  public static void main(String[] args) {
    Scanner in = new Scanner(FindTheRunningMedian.class.getClassLoader().getResourceAsStream(
      "hackerrank/datastructure/heap/find_the_running_median.txt"));

    int n = in.nextInt();
    ArrayList<Integer> a = new ArrayList<>();

    int numCount = 0;
    for (int a_i = 0; a_i < n; a_i++) {
      int next = in.nextInt();

      int nextIndex = Collections.binarySearch(a, next);
      if (nextIndex < 0) {
        a.add(-(nextIndex + 1), next);
      } else {
        a.add(nextIndex, next);
      }
      numCount++;

      if (numCount % 2 == 0) {
        System.out.println(((double) a.get(numCount / 2) + a.get(numCount / 2 - 1)) / 2);
      } else {
        System.out.println((double) a.get(numCount / 2));
      }
    }
  }
}