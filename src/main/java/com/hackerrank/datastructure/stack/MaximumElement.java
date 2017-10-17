package com.hackerrank.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/maximum-element/problem
 */
public class MaximumElement {
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();

        Scanner in = new Scanner(MaximumElement.class.getClassLoader()
                .getResourceAsStream("hackerrank/datastructure/stack/maximum_element.txt"));
        int commandsCount = in.nextInt();
        in.nextLine();

        for (int i = 0; i < commandsCount; i++) {
            String command = in.nextLine();
            String[] parts = command.split(" ");
            switch (Integer.valueOf(parts[0])) {
                case 1:
                    stack.push(Integer.valueOf(parts[1]));
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(stack.max());
                    break;

            }
        }
    }

    private static class MaxStack {
        private Stack<Integer> values;

        private Stack<Integer> max;

        public MaxStack() {
            this.values = new Stack<>();
            this.max = new Stack<>();
        }

        public void push(int value) {
            values.push(value);
            if (max.isEmpty()) {
                max.push(value);
            } else if (max.peek() <= value) {
                max.push(value);
            }
        }

        public int pop() {
            int value = values.pop();
            if (max.peek() == value) {
                max.pop();
            }
            return value;
        }

        public int max() {
            return max.peek();
        }
    }
}