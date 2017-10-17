package com.hackerrank.datastructure.stack;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-two-stacks/problem
 */
public class GameOfTwoStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(GameOfTwoStacks.class.getClassLoader()
                .getResourceAsStream("hackerrank/datastructure/stack/game_of_two_stacks.txt"));
        int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for (int b_i = 0; b_i < m; b_i++) {
                b[b_i] = in.nextInt();
            }
            int currentMoves = solve(a, b, x);
            System.out.println(currentMoves);
        }
    }

    private static int solve(int[] a, int[] b, int x) {
        int lengthB = 0;
        int sum = 0;
        while (lengthB < b.length && sum + b[lengthB] <= x) {
            sum += b[lengthB];
            lengthB++;
        }

        int maxScore = lengthB;
        for (int lengthA = 1; lengthA <= a.length; lengthA++) {
            sum += a[lengthA - 1];

            while (sum > x && lengthB > 0) {
                lengthB--;
                sum -= b[lengthB];
            }

            if (sum > x) {
                break;
            }

            maxScore = Math.max(maxScore, lengthA + lengthB);
        }
        return maxScore;
    }
}
