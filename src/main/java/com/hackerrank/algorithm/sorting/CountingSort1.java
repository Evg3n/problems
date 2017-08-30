package com.hackerrank.algorithm.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort1
 */
public class CountingSort1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(CountingSort1.class.getClassLoader().getResourceAsStream(
                "algorithm/sorting/counting_sort_1.txt"));

        int n = in.nextInt();
        int[] unsorted = new int[n];
        for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
            unsorted[unsorted_i] = in.nextInt();
        }

        int[] counts = buildCountsArray(unsorted, 100);

        StringBuilder sb = new StringBuilder();
        for (int c : counts) {
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
}