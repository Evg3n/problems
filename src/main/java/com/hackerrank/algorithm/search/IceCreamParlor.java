package com.hackerrank.algorithm.search;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor/
 */
public class IceCreamParlor {
    public static void main(String[] args) {
        Scanner in = new Scanner(IceCreamParlor.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/search/ice_cream_parlor.txt"));

        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            // money
            int m = in.nextInt();
            // number of flavors
            int n = in.nextInt();
            // flavors
            int a[] = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }

            // find unique flavors
            int[][] sums = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    sums[i][j] = a[i] + a[j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (sums[i][j] == m) {
                        System.out.println(j + 1 + " " + (i + 1));
                    }
                }
            }
        }
    }
}