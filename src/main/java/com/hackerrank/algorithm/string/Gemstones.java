package com.hackerrank.algorithm.string;

import com.hackerrank.datastructure.trie.Contacts;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/gem-stones
 */
public class Gemstones {
    public static void main(String[] args) {
        Scanner in = new Scanner(Contacts.class.getClassLoader().getResourceAsStream(
                "algorithm/string/gemstones.txt"));

        int n = in.nextInt();
        String[] arr = new String[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
    }

    private static int gemstones(String[] arr) {
        int[] elements = new int[26];
        for (String stone : arr) {
            int[] currElements = new int[26];
            for (int j = 0; j < stone.length(); j++) {
                int position = stone.charAt(j) - 'a';
                currElements[position] = 1;
            }

            for (int j = 0; j < elements.length; j++) {
                elements[j] += currElements[j];
            }
        }

        int gemsElementsCount = 0;
        for (int elem : elements) {
            if (elem == arr.length) {
                gemsElementsCount++;
            }
        }

        return gemsElementsCount;
    }
}