package com.hackerrank.datastructure.array;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 */
public class Array2D {
  public static void main(String[] args) {
    Scanner in = new Scanner(Array2D.class.getClassLoader()
      .getResourceAsStream("hackerrank/datastructure/array/array_2d.txt"));
    int arr[][] = new int[6][6];
    for (int arr_i = 0; arr_i < 6; arr_i++) {
      for (int arr_j = 0; arr_j < 6; arr_j++) {
        arr[arr_i][arr_j] = in.nextInt();
      }
    }

    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int currentSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
          + arr[i + 1][j + 1]
          + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
        if (currentSum > maxSum) {
          maxSum = currentSum;
        }
      }
    }

    System.out.print(maxSum);
  }
}