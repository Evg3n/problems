package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string
 */
public class HackerRankInAString {
    public static void main(String[] args) {
        Scanner in = new Scanner(HackerRankInAString.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/string/hacker_rank_in_a_string.txt"));

        int stringsCount = in.nextInt();

        for (int i = 0; i < stringsCount; i++) {
            System.out.println(containsHackerRank(in.next()) ? "YES" : "NO");
        }
    }

    private static boolean containsHackerRank(String source) {
        String hackerRank = "hackerrank";

        if (source.length() < hackerRank.length()) {
            return false;
        }

        int hackIndex = 0;
        int sourceIndex = 0;
        while (hackIndex < hackerRank.length()) {
            if (sourceIndex == source.length()) {
                return false;
            }
            while (sourceIndex < source.length()) {
                if (source.charAt(sourceIndex) == hackerRank.charAt(hackIndex)) {
                    hackIndex++;
                    sourceIndex++;
                    break;
                }
                sourceIndex++;
            }
        }

        return hackIndex == hackerRank.length();
    }
}