package com.hackerrank.algorithm.bitmanipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flipping-bits
 */
public class FlippingBits {
  public static void main(String[] args) {
    Scanner in = new Scanner(FlippingBits.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/bitmanipulation/flipping_bits.txt"));

    int count = in.nextInt();
    long mask = 0xffffffffL;
    for (int i = 0; i < count; i++) {
      long source = Long.valueOf(in.next());
      long result = source ^ mask;
      System.out.println(result);
    }
  }
}