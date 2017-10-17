package com.hackerrank.algorithm.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/weighted-uniform-string
 */
public class WeightedUniformStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(WeightedUniformStrings.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/string/weighted_uniform_strings.txt"));

        String source = in.nextLine();
        Set<Integer> weights = buildWeights(source);

        int queriesCount = in.nextInt();
        for (int i = 0; i < queriesCount; i++) {
            System.out.println(weights.contains(in.nextInt()) ? "Yes" : "No");
        }
    }

    private static Set<Integer> buildWeights(String source) {
        Set<Integer> weights = new HashSet<>();

        int weight = 0;
        char previousChar = 0;
        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            if (previousChar == currentChar) {
                weight += currentChar - 'a' + 1;
            } else {
                weight = currentChar - 'a' + 1;
            }
            weights.add(weight);
            previousChar = currentChar;
        }

        return weights;
    }
}