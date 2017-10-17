package com.hackerrank.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/waiter/problem
 */
public class Waiter {
    public static void main(String[] args) {
        Scanner in = new Scanner(Waiter.class.getClassLoader()
                .getResourceAsStream("hackerrank/datastructure/stack/waiter.txt"));
        int n = in.nextInt();
        int q = in.nextInt();
        int[] number = new int[n];

        Stack<Integer>[] a = (Stack<Integer>[]) new Stack[q + 1];
        Stack<Integer>[] b = (Stack<Integer>[]) new Stack[q + 1];

        for (int i = 0; i <= q; i++) {
            a[i] = new Stack<>();
            b[i] = new Stack<>();
        }

        for (int number_i = 0; number_i < n; number_i++) {
            number[number_i] = in.nextInt();
            a[0].push(number[number_i]);
        }

        Integer[] primes = getPrimes(q);

        for (int i = 1; i <= q; i++) {
            while (!a[i - 1].isEmpty()) {
                int plate = a[i - 1].pop();
                if (plate % primes[i - 1] == 0) {
                    b[i].push(plate);
                } else {
                    a[i].push(plate);
                }
            }
        }

        for (int i = 1; i <= q; i++) {
            while (!b[i].isEmpty()) {
                System.out.println(b[i].pop());
            }
        }


        while (!a[q].isEmpty()) {
            System.out.println(a[q].pop() + " ");
        }
    }

    private static Integer[] getPrimes(int numbersCount) {
        int i = 1;
        int num;
        int iterations = 0;
        List<Integer> primes = new ArrayList<>();
        while (true) {
            if (iterations == numbersCount) {
                break;
            }
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                primes.add(i);
                iterations++;
            }
            i++;
        }
        return primes.toArray(new Integer[primes.size()]);
    }
}