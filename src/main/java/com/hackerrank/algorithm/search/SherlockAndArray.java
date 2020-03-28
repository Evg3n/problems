package com.hackerrank.algorithm.search;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array
 */
public class SherlockAndArray {
  public static void main(String[] args) {
    Scanner in = new Scanner(SherlockAndArray.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/search/sherlock_and_array.txt"));

    int T = in.nextInt();
    for (int a0 = 0; a0 < T; a0++) {
      int n = in.nextInt();
      int[] a = new int[n];
      for (int a_i = 0; a_i < n; a_i++) {
        a[a_i] = in.nextInt();
      }
      String result = solve(a);
      System.out.println(result);
    }
  }

  private static String solve(int[] a) {
    int[] prefixSum = new int[a.length + 1];
    int[] postfixSum = new int[a.length + 1];

    for (int i = 1; i <= a.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + a[i - 1];
      postfixSum[i] = postfixSum[i - 1] + a[a.length - i];
    }

    boolean exists = false;
    for (int i = 1; i < prefixSum.length; i++) {
      if (prefixSum[i - 1] == postfixSum[postfixSum.length - i - 1]) {
        exists = true;
        break;
      }
    }

    return exists ? "YES" : "NO";
  }
}