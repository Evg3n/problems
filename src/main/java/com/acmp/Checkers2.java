package com.acmp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://acmp.ru/index.asp?main=task&id_task=684
 * <p>
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class Checkers2 {
  public static void main(String[] args) throws FileNotFoundException {
    runLocal();
  }

  private static void runLocal() throws FileNotFoundException {
    try (
      Scanner sc = new Scanner(
        Checkers2.class.getClassLoader().getResourceAsStream("acmp/checkers_input.txt"));
      PrintWriter out = new PrintWriter(new File("checkers_output.txt"))
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
    String source = sc.next();
    String target = sc.next();

    int deltaX = target.charAt(0) - source.charAt(0);
    int deltaY = target.charAt(1) - source.charAt(1);

    out.write((deltaY - deltaX) % 2 == 0 && Math.abs(deltaX) <= deltaY ? "YES" : "NO");
  }
}