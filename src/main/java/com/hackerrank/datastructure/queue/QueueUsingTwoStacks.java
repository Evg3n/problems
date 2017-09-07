package com.hackerrank.datastructure.queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
 */
public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue<>();

        Scanner scan = new Scanner(QueueUsingTwoStacks.class.getClassLoader()
                .getResourceAsStream("datastructure/queue/queue_using_two_stacks.txt"));
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            switch (operation) {
                case 1:
                    // enqueue
                    queue.enqueue(scan.nextInt());
                    break;
                case 2:
                    //dequeue
                    queue.dequeue();
                    break;
                case 3:
                    // print/peek
                    System.out.println(queue.peek());
                    break;
            }
        }
        scan.close();
    }

    private static class TwoStacksQueue<T> {
        private Stack<T> newest;
        private Stack<T> oldest;

        public TwoStacksQueue() {
            newest = new Stack<>();
            oldest = new Stack<>();
        }

        public void enqueue(T value) {
            newest.push(value);
        }

        public T dequeue() {
            pushElementsToOldest();
            return (T) oldest.pop();
        }

        public T peek() {
            pushElementsToOldest();
            return (T) oldest.peek();
        }

        private void pushElementsToOldest() {
            if (oldest.isEmpty()) {
                while (!newest.isEmpty()) {
                    oldest.push(newest.pop());
                }
            }
        }
    }
}