package com.hackerrank.algorithm.bitmanipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximizing-xor
 */
public class MaximizingXOR {
  public static void main(String[] args) {
    Scanner in = new Scanner(MaximizingXOR.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/bitmanipulation/maximizing_xor.txt"));

    int l = in.nextInt();
    int r = in.nextInt();

    int maxXor = Integer.MIN_VALUE;
    for (int i = l; i < r; i++) {
      for (int j = l + 1; j <= r; j++) {
        int xor = i ^ j;
        maxXor = Math.max(maxXor, xor);
      }
    }

    System.out.println(maxXor);
  }
}