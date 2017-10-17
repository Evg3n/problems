
package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/separate-the-numbers
 */
public class SeparateTheNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(Pangrams.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/string/separate_the_numbers.txt"));
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            long result = check(s);
            if (result >= 0) {
                System.out.println("YES " + result);
            } else {
                System.out.println("NO");
            }
        }
    }

    private static long check(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            long first = Long.valueOf(s.substring(0, i));
            if (verifyTail(s, first)) {
                return first;
            }
        }
        return -1;
    }

    private static boolean verifyTail(String s, long first) {
        int index = 0;
        while (s.substring(index).startsWith(String.valueOf(first))) {
            index += String.valueOf(first).length();
            first++;
        }
        return index == s.length();
    }
}