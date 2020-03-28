package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-love-letter-mystery/problem
 */
public class TheLoveLetterMystery {
  public static void main(String[] args) {
    Scanner in = new Scanner(Pangrams.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/string/the_love_letter_mystery.txt"));

    int count = in.nextInt();
    for (int i = 0; i < count; i++) {
      String s = in.next();
      System.out.println(getPalindromeCount(s));
    }
  }

  private static int getPalindromeCount(String source) {
    int count = 0;
    for (int i = 0; i < source.length() / 2; i++) {
      char firstChar = source.charAt(i);
      char secondChar = source.charAt(source.length() - 1 - i);
      if (firstChar != secondChar) {
        count += Math.abs(firstChar - secondChar);
      }
    }
    return count;
  }
}