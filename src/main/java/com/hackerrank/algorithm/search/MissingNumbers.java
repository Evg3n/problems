package com.hackerrank.algorithm.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/missing-numbers/
 */
public class MissingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(MissingNumbers.class.getClassLoader().getResourceAsStream(
                "algorithm/search/missing_numbers.txt"));

        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }

        Integer[] result = getMissingNumbers(a, b);
        for (Integer aResult : result) {
            System.out.print(aResult + " ");
        }
    }

    private static Integer[] getMissingNumbers(int[] a, int[] b) {
        int[] counts = new int[10001];
        for (int num : a) {
            counts[num] += 1;
        }

        for (int num : b) {
            counts[num] -= 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                result.add(i);
            }
        }

        Collections.sort(result);
        return result.toArray(new Integer[]{});
    }
}