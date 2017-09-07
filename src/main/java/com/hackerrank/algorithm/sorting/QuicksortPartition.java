package com.hackerrank.algorithm.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort1/problem
 */
public class QuicksortPartition {
    static void partition(int[] ar) {
        int pivot = ar[0];

        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int j = 0; j < ar.length; j++) {
            if (ar[j] == pivot) {
                equal.add(ar[j]);
            } else if (ar[j] < pivot) {
                left.add(ar[j]);
            } else {
                right.add(ar[j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(left);
        result.addAll(equal);
        result.addAll(right);

        printArray(result.toArray(new Integer[]{}));
    }

    static void printArray(Integer[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(QuicksortPartition.class.getClassLoader().getResourceAsStream(
                "algorithm/sorting/quicksort_partition.txt"));
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        partition(ar);
    }
}