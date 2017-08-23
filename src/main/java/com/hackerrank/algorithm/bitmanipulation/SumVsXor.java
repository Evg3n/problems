package com.hackerrank.algorithm.bitmanipulation;

import com.hackerrank.algorithm.search.SherlockAndArray;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sum-vs-xor
 */
public class SumVsXor {
    public static void main(String[] args) {
        Scanner in = new Scanner(SherlockAndArray.class.getClassLoader().getResourceAsStream(
                "algorithm/bitmanipulation/sum_vs_xor.txt"));

        long n = in.nextLong();
        long result = solve(n);
        System.out.println(result);
    }

    private static long solve(long n) {
        int count = 0;

        while (n > 0) {
            boolean zero = ((n & 1) == 0);
            if (zero) {
                count++;
            }
            n = n >> 1;
        }
        return 1L << count;
    }
}