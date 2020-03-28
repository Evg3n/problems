package com.hackerrank.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/simple-text-editor/problem
 */
public class SimpleTextEditor {
  public static void main(String[] args) {
    Scanner in = new Scanner(SimpleTextEditor.class.getClassLoader()
      .getResourceAsStream("hackerrank/datastructure/stack/simple_text_editor.txt"));

    int commandsCount = in.nextInt();
    in.nextLine();

    Stack<String> state = new Stack<>();
    String currentString = "";

    for (int i = 0; i < commandsCount; i++) {
      String command = in.nextLine();

      String[] parts = command.split(" ");
      switch (Integer.valueOf(parts[0])) {
        case 1:
          state.push(currentString);
          currentString += parts[1];
          break;
        case 2:
          state.push(currentString);
          currentString = currentString.substring(0, currentString.length() - Integer.valueOf(parts[1]));
          break;
        case 3:
          System.out.println(currentString.charAt(Integer.valueOf(parts[1]) - 1));
          break;
        case 4:
          currentString = state.pop();
          break;
      }
    }
  }
}
