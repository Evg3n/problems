package com.hackerrank.algorithm.string;

import com.hackerrank.datastructure.trie.Contacts;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/funny-string
 */
public class FunnyString {
    public static void main(String[] args) {
        Scanner in = new Scanner(Contacts.class.getClassLoader().getResourceAsStream(
                "algorithm/string/funny_string.txt"));

        int stringsCount = in.nextInt();
        in.nextLine();

        for (int i = 0; i < stringsCount; i++) {
            String source = in.nextLine();
            System.out.println(funnyString(source));
        }
    }

    static String funnyString(String s) {
        String reversedSource = new StringBuffer(s).reverse().toString();

        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) !=
                    Math.abs(reversedSource.charAt(i) - reversedSource.charAt(i - 1))) {
                return "Not Funny";
            }
        }

        return "Funny";
    }
}