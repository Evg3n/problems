package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/making-anagrams/problem
 */
public class MakingAnagrams {
  public static void main(String[] args) {
    Scanner in = new Scanner(MakingAnagrams.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/string/making_anagrams.txt"));
    String s1 = in.next();
    String s2 = in.next();
    int result = makingAnagrams(s1, s2);
    System.out.println(result);
  }

  private static int makingAnagrams(String s1, String s2) {
    int[] counts1 = new int[26];
    int[] counts2 = new int[26];

    for (char c : s1.toCharArray()) {
      counts1[c - 'a'] += 1;
    }

    for (char c : s2.toCharArray()) {
      counts2[c - 'a'] += 1;
    }

    int count = 0;
    for (int i = 0; i < 26; i++) {
      count += Math.abs(counts1[i] - counts2[i]);
    }

    return count;
  }
}