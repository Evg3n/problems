package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 */
public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(AlternatingCharacters.class.getClassLoader().getResourceAsStream(
                "algorithm/string/alternating_characters.txt"));

        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
    }

    private static int alternatingCharacters(String s) {
        char[] pair = new char[]{'A', 'B'};
        int offset = 0;
        if (s.charAt(0) == 'B') {
            offset = 1;
        }

        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pair[offset % 2]) {
                result++;
            } else {
                offset++;
            }
        }

        return result;
    }
}