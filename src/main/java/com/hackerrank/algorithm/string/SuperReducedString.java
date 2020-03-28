package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/reduced-string
 */
public class SuperReducedString {
  public static void main(String[] args) {
    Scanner in = new Scanner(SuperReducedString.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/string/super_reduced_string.txt"));

    String source = in.nextLine();

    String result = source;
    boolean deleted = true;
    while (deleted) {
      if (result.isEmpty()) {
        break;
      }

      deleted = false;

      for (int i = 1; i < result.length(); i++) {
        if (result.charAt(i - 1) == result.charAt(i)) {
          result = result.substring(0, i - 1) + result.substring(i + 1, result.length());
          deleted = true;
          break;
        }
      }
    }

    System.out.println(result.isEmpty() ? "Empty String" : result);
  }
}