package com.hackerrank.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 */
public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(BalancedBrackets.class.getClassLoader()
                .getResourceAsStream("hackerrank/datastructure/stack/balanced_brackets.txt"));
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }

    static String isBalanced(String s) {
        if (s.length() % 2 != 0) {
            return "NO";
        }

        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                chars.push(s.charAt(i));
            } else {
                if (chars.isEmpty()) {
                    return "NO";
                }
                if (current == ')' && chars.peek() == '(') {
                    chars.pop();
                } else if (current == ']' && chars.peek() == '[') {
                    chars.pop();
                } else if (current == '}' && chars.peek() == '{') {
                    chars.pop();
                }
            }
        }

        return chars.isEmpty() ? "YES" : "NO";
    }
}