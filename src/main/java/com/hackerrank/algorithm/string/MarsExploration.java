package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mars-exploration
 */
public class MarsExploration {
    public static void main(String[] args) {
        Scanner in = new Scanner(MarsExploration.class.getClassLoader().getResourceAsStream(
                "algorithm/string/mars_exploration.txt"));

        String source = in.next();
        System.out.println(countMistakes(source));
    }

    private static int countMistakes(String source) {
        String sos = "SOS";

        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != sos.charAt(i % 3)) {
                count++;
            }
        }

        return count;
    }
}