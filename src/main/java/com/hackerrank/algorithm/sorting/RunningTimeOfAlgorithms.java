package com.hackerrank.algorithm.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/runningtime/problem
 */
public class RunningTimeOfAlgorithms {
    public static void main(String[] args) {
        Scanner in = new Scanner(RunningTimeOfAlgorithms.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/sorting/running_time_of_algorithms.txt"));
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        int shifts = insertionSortPart2(ar);
        System.out.println(shifts);
    }

    private static int insertionSortPart2(int[] ar) {
        int shifts = 0;
        for (int i = 1; i < ar.length; i++) {
            int value = ar[i];
            int index = 0;
            while (index < i && ar[index] <= value) {
                index++;
            }

            shifts = shifts + i - index;

            for (int j = i; j > index; j--) {
                ar[j] = ar[j - 1];
            }
            ar[index] = value;
        }
        return shifts;
    }
}