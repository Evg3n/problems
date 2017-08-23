package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/two-strings
 */
public class TwoStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(TwoStrings.class.getClassLoader().getResourceAsStream(
                "algorithm/string/two_strings.txt"));

        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
    }

    private static String twoStrings(String s1, String s2) {
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];

        for (char c : s1.toCharArray()) {
            counts1[c - 'a'] += 1;
        }
        for (char c : s2.toCharArray()) {
            counts2[c - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (counts1[i] != 0 && counts2[i] != 0) {
                return "YES";
            }
        }

        return "NO";
    }
}