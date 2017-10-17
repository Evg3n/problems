package com.hackerrank.algorithm.greedy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/grid-challenge/problem
 */
public class GridChallenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(GridChallenge.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/greedy/grid_challenge.txt"));

        int testsCount = in.nextInt();
        for (int i = 0; i < testsCount; i++) {
            int gridSize = in.nextInt();
            in.nextLine();

            String[] grid = new String[gridSize];
            for (int j = 0; j < gridSize; j++) {
                grid[j] = in.nextLine();
            }

            rearrangeGrid(grid);

            System.out.println(isValidGrid(grid) ? "YES" : "NO");
        }
    }

    private static void rearrangeGrid(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            grid[i] = sortString(grid[i]);
        }
    }

    private static String sortString(String source) {
        int[] counts = buildCountsArray(source, 26);
        return buildSortedString(source.length(), counts);
    }

    private static int[] buildCountsArray(String source, int rangeSize) {
        int[] counts = new int[rangeSize];

        for (char n : source.toCharArray()) {
            counts[n - 'a']++;
        }

        return counts;
    }

    private static String buildSortedString(int arraySize, int[] counts) {
        char[] sorted = new char[arraySize];

        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            int c = counts[i];
            for (int j = 0; j < c; j++) {
                sorted[index + j] = (char) (i + 'a');
            }
            index += c;
        }

        return new String(sorted);
    }

    private static boolean isValidGrid(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            for (int j = 0; j < s.length(); j++) {
                for (int k = j + 1; k < s.length(); k++) {
                    if (s.charAt(j) > s.charAt(k)) {
                        return false;
                    }
                }

                for (int k = i + 1; k < grid.length; k++) {
                    String s1 = grid[k];
                    if (s.charAt(j) > s1.charAt(j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}