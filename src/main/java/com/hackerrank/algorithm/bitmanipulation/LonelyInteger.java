package com.hackerrank.algorithm.bitmanipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lonely-integer
 */
public class LonelyInteger {
  public static void main(String[] args) {
    Scanner in = new Scanner(LonelyInteger.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/bitmanipulation/lonely_integer.txt"));

    int n = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    int result = lonelyInteger(a);
    System.out.println(result);
  }

  private static int lonelyInteger(int[] a) {
    int lonelyInt = a[0];

    for (int i = 1; i < a.length; i++) {
      lonelyInt ^= a[i];
    }
    return lonelyInt;
  }
}