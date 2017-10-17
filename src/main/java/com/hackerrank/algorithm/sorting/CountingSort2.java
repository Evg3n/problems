package com.hackerrank.algorithm.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort2
 */
public class CountingSort2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(CountingSort2.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/sorting/counting_sort_2.txt"));

        int n = in.nextInt();
        int[] unsorted = new int[n];
        for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
            unsorted[unsorted_i] = in.nextInt();
        }

        int[] counts = buildCountsArray(unsorted, 100);
        int[] sorted = buildSortedArray(n, counts);

        StringBuilder sb = new StringBuilder();
        for (int c : sorted) {
            sb.append(c);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int[] buildCountsArray(int[] source, int rangeSize) {
        int[] counts = new int[rangeSize];

        for (int n : source) {
            counts[n]++;
        }

        return counts;
    }

    private static int[] buildSortedArray(int arraySize, int[] counts) {
        int[] sorted = new int[arraySize];

        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            int c = counts[i];
            for (int j = 0; j < c; j++) {
                sorted[index + j] = i;
            }
            index += c;
        }

        return sorted;
    }
}