package com.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/correctness-invariant/problem
 */
public class CorrectnessAndTheLoopInvariant {
    public static void main(String[] args) {
        Scanner in = new Scanner(CorrectnessAndTheLoopInvariant.class.getClassLoader()
                .getResourceAsStream("algorithm/sorting/correctness_and_the_loop_invariant.txt"));
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        insertionSort(ar);
    }

    private static void insertionSort(int[] ar) {
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
        }
        printArray(ar);
    }

    private static void printArray(int[] ar) {
        String arrayStr = Arrays.toString(ar);
        System.out.println(arrayStr.substring(1, arrayStr.length() - 1).replaceAll(", ", " "));
    }
}
