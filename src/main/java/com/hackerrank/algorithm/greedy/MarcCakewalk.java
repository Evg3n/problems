package com.hackerrank.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/marcs-cakewalk
 */
public class MarcCakewalk {
  public static void main(String[] args) {
    Scanner in = new Scanner(MarcCakewalk.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/greedy/marc_cakewalk.txt"));
    int n = in.nextInt();
    int[] calories = new int[n];
    for (int calories_i = 0; calories_i < n; calories_i++) {
      calories[calories_i] = in.nextInt();
    }
    // your code goes here
    System.out.println(getMiles(calories));
  }

  private static long getMiles(int[] calories) {
    Arrays.sort(calories);
    long miles = 0;

    for (int i = 0; i < calories.length; i++) {
      miles += calories[calories.length - 1 - i] * Math.pow(2, i);
    }

    return miles;
  }
}