package com.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort1/problem
 */
public class InsertionSortPart1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(InsertionSortPart1.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/sorting/insertion_sort_part_1.txt"));
    int s = in.nextInt();
    int[] ar = new int[s];
    for (int i = 0; i < s; i++) {
      ar[i] = in.nextInt();
    }
    insertIntoSorted(ar);
  }


  private static void insertIntoSorted(int[] ar) {
    int value = ar[ar.length - 1];
    int index = 0;
    while (index < ar.length - 1 && ar[index] < value) {
      index++;
    }

    for (int i = ar.length - 1; i > index; i--) {
      ar[i] = ar[i - 1];
      printArray(ar);
    }
    ar[index] = value;
    printArray(ar);
  }


  private static void printArray(int[] ar) {
    String arrayStr = Arrays.toString(ar);
    System.out.println(arrayStr.substring(1, arrayStr.length() - 1).replaceAll(", ", " "));
  }
}