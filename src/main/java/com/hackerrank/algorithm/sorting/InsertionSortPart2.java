package com.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort2/problem
 */
public class InsertionSortPart2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(InsertionSortPart2.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/sorting/insertion_sort_part_2.txt"));
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);
    }

    private static void insertionSortPart2(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int value = ar[i];
            int index = 0;
            while (index < ar.length - 1 && ar[index] < value) {
                index++;
            }
            for (int j = i; j > index; j--) {
                ar[j] = ar[j - 1];
            }
            ar[index] = value;
            printArray(ar);
        }
    }

    private static void printArray(int[] ar) {
        String arrayStr = Arrays.toString(ar);
        System.out.println(arrayStr.substring(1, arrayStr.length() - 1).replaceAll(", ", " "));
    }
}
