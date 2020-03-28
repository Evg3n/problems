package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/palindrome-index
 */
public class PalindromeIndex {
  public static void main(String[] args) {
    Scanner in = new Scanner(PalindromeIndex.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/string/palindrome _index.txt"));

    int count = in.nextInt();

    for (int i = 0; i < count; i++) {
      String source = in.next();
      System.out.println(palindromeIndex(source));
    }
  }

  private static int palindromeIndex(String s) {
    int index = -1;

    int frontIndex = 0;
    int backIndex = s.length() - 1;

    while (frontIndex < backIndex) {
      char frontChar = s.charAt(frontIndex);
      char backChar = s.charAt(backIndex);
      if (frontChar != backChar) {

        boolean frontPalinodrome = isPalindrome(s.substring(0, frontIndex) + s.substring(frontIndex + 1));
        boolean backPalinodrome = isPalindrome(s.substring(0, backIndex) + s.substring(backIndex + 1));

        if (frontPalinodrome) {
          index = frontIndex;
          break;
        }
        if (backPalinodrome) {
          index = backIndex;
          break;
        }
      }

      frontIndex++;
      backIndex--;
    }

    return index;
  }

  private static boolean isPalindrome(String source) {
    int frontIndex = 0;
    int backIndex = source.length() - 1;
    while (frontIndex < backIndex) {
      if (source.charAt(frontIndex) != source.charAt(backIndex)) {
        return false;
      }
      frontIndex++;
      backIndex--;
    }
    return true;
  }
}