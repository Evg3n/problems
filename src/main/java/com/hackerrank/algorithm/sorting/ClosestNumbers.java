package com.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/closest-numbers
 */
public class ClosestNumbers {
  public static void main(String[] args) {
    Scanner in = new Scanner(ClosestNumbers.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/sorting/closest_numbers.txt"));

    int n = in.nextInt();
    int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }

    Arrays.sort(arr);

    int minDiff = minimumAbsoluteDifference(arr);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - arr[i - 1] == minDiff) {
        sb.append(arr[i - 1]);
        sb.append(" ");
        sb.append(arr[i]);
        sb.append(" ");
      }
    }

    System.out.println(sb.toString().trim());

    in.close();
  }

  private static int minimumAbsoluteDifference(int[] arr) {
    int minAbsValue = Integer.MAX_VALUE;
    Arrays.sort(arr);
    for (int i = 1; i < arr.length; i++) {
      minAbsValue = Math.min(minAbsValue, arr[i] - arr[i - 1]);
    }
    return minAbsValue;
  }
}