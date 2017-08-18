package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pangrams
 */
public class Pangrams {
    public static void main(String[] args) {
        Scanner in = new Scanner(Pangrams.class.getClassLoader().getResourceAsStream(
                "algorithm/string/pangrams.txt"));

        System.out.println(isPangram(in.nextLine()) ? "pangram" : "not pangram");
    }

    private static boolean isPangram(String source) {
        int[] abc = new int[26];

        for (char currChar : source.toLowerCase().toCharArray()) {
            if (' ' != currChar) {
                abc[currChar - 'a'] = 1;
            }
        }

        boolean result = true;
        for (int anAbc : abc) {
            if (anAbc == 0) {
                result = false;
                break;
            }
        }

        return result;
    }
}