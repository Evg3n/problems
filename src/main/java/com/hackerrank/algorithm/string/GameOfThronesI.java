package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-thrones
 */
public class GameOfThronesI {
  public static void main(String[] args) {
    Scanner in = new Scanner(GameOfThronesI.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/string/game_of_thrones_i.txt"));

    String s = in.next();
    String result = gameOfThrones(s);
    System.out.println(result);
  }

  private static String gameOfThrones(String s) {
    int[] letterCounts = new int[26];
    for (char c : s.toCharArray()) {
      letterCounts[c - 'a'] += 1;
    }

    int singleLetterCount = 0;
    for (int i = 0; i < 26; i++) {
      if (letterCounts[i] % 2 == 1) {
        singleLetterCount++;
      }
    }

    return singleLetterCount <= 1 ? "YES" : "NO";
  }
}