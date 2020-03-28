package com.acmp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://acmp.ru/index.asp?main=task&id_task=303
 * <p>
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class Digits {
  public static void main(String[] args) throws FileNotFoundException {
    runLocal();
  }

  private static void runLocal() throws FileNotFoundException {
    try (
      Scanner sc = new Scanner(
        Digits.class.getClassLoader().getResourceAsStream("acmp/digits_input.txt"));
      PrintWriter out = new PrintWriter(new File("digits_output.txt"))
    ) {
      solve(sc, out);
    }
  }

  private static void runAcmp() throws FileNotFoundException {
    try (
      Scanner sc = new Scanner(new File("input.txt"));
      PrintWriter out = new PrintWriter(new File("output.txt"))
    ) {
      solve(sc, out);
    }
  }

  private static void solve(Scanner sc, PrintWriter out) {
    String line = sc.next();

    int[] left = new int[line.length()];
    for (int i = 1; i < line.length(); i++) {
      left[i] = left[i - 1] + (line.charAt(i - 1) - '0') * (i % 2 == 1 ? 1 : -1);
    }

    int[] right = new int[line.length()];
    for (int i = line.length() - 2; i > -1; i--) {
      right[i] = right[i + 1] + (line.charAt(i + 1) - '0') * (i % 2 == 1 ? -1 : 1);
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < line.length(); i++) {
      int current = left[i] + right[i];
      if (current > max) {
        max = current;
      }
    }
    out.write(Integer.toString(max));
    out.close();
  }
}