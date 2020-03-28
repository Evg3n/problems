package com.hackerrank.algorithm.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/string-construction/problem
 */
public class StringConstruction {
  public static void main(String[] args) {
    Scanner in = new Scanner(Pangrams.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/string/string_construction.txt"));

    int count = in.nextInt();
    for (int i = 0; i < count; i++) {
      System.out.println(getCopyCount(in.next()));
    }
  }

  private static int getCopyCount(String source) {
    int cost = 0;
    Set<Character> metChars = new HashSet<>();
    for (int i = 0; i < source.length(); i++) {
      Character currChar = source.charAt(i);
      if (!metChars.contains(currChar)) {
        cost++;
        metChars.add(currChar);
      }
    }
    return cost;
  }
}