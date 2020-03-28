package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/anagram
 */
public class Anagram {
  public static void main(String[] args) {
    Scanner in = new Scanner(Anagram.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/string/anagram.txt"));

    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      int result = anagram(s);
      System.out.println(result);
    }
  }

  private static int anagram(String s) {
    if (s.length() % 2 == 1) {
      return -1;
    }
    int count = 0;

    String str1 = s.substring(0, s.length() / 2);
    String str2 = s.substring(s.length() / 2);

    int[] counts1 = new int[26];
    int[] counts2 = new int[26];

    for (char c : str1.toCharArray()) {
      counts1[c - 'a'] += 1;
    }
    for (char c : str2.toCharArray()) {
      counts2[c - 'a'] += 1;
    }

    for (int i = 0; i < 26; i++) {
      count += Math.abs(counts1[i] - counts2[i]);
    }

    return count / 2;
  }
}
