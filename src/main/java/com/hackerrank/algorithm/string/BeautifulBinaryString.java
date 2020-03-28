package com.hackerrank.algorithm.string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/beautiful-binary-string
 */
public class BeautifulBinaryString {
  public static void main(String[] args) {
    Scanner in = new Scanner(BeautifulBinaryString.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/string/beautiful_binary_string.txt"));
    int n = in.nextInt();
    String source = in.next();

    Pattern pattern = Pattern.compile("010");
    Matcher matcher = pattern.matcher(source);

    int count = 0;
    while (matcher.find()) {
      count++;
    }

    System.out.println(count);
  }
}