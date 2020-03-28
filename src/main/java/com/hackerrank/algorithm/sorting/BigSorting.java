package com.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/big-sorting/problem
 */
public class BigSorting {
  public static void main(String[] args) {
    Scanner in = new Scanner(BigSorting.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/sorting/big_sorting.txt"));

    int n = in.nextInt();
    String[] unsorted = new String[n];
    for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
      unsorted[unsorted_i] = in.next();
    }

    Arrays.sort(unsorted, (o1, o2) -> {
      if (o1.length() != o2.length()) {
        return o1.length() - o2.length();
      }

      return o1.compareTo(o2);
    });
    StringBuilder sb = new StringBuilder();
    for (String s : unsorted) {
      sb.append(s).append("\n");
    }
    System.out.println(sb.toString());
  }
}