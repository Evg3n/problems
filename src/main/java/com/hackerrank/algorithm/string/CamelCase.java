package com.hackerrank.algorithm.string;

import com.hackerrank.datastructure.trie.Contacts;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/camelcase
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(Contacts.class.getClassLoader().getResourceAsStream(
                "algorithm/string/camel_case.txt"));

        String source = in.nextLine();
        int count = 1;
        for (int i = 1; i < source.length(); i++) {
            int charNumber = source.charAt(i);
            if (charNumber >= 65 && charNumber <= 90) {
                count++;
            }
        }

        System.out.println(count);
    }
}