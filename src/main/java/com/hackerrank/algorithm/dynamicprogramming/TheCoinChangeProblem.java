package com.hackerrank.algorithm.dynamicprogramming;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/coin-change/
 */
public class TheCoinChangeProblem {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(TheCoinChangeProblem.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/dynamicprogramming/the_coin_change_problem.txt"));

        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }

        System.out.println(numberOfChangesDP(n, coins));
    }

    private static long numberOfChangesDP(int sum, int[] coins) {
        long[] cache = new long[sum + 1];
        cache[0] = (long) 1;
        for (int coin : coins) {
            for (int j = coin; j < cache.length; j++) {
                cache[j] += cache[j - coin];
            }
        }
        return cache[sum];
    }
}