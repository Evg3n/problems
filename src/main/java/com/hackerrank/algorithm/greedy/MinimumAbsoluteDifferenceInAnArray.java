package com.hackerrank.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
 */
public class MinimumAbsoluteDifferenceInAnArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(MinimumAbsoluteDifferenceInAnArray.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/greedy/minimum_absolute_differenceIn_an_array.txt"));

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }

    private static int minimumAbsoluteDifference(int n, int[] arr) {
        int minAbsValue = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            minAbsValue = Math.min(minAbsValue, Math.abs(arr[i - 1] - arr[i]));
        }
        return minAbsValue;
    }
}