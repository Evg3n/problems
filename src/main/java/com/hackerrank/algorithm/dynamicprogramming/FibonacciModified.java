package com.hackerrank.algorithm.dynamicprogramming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified/
 */
public class FibonacciModified {
    public static BigInteger fibonacci(int n, BigInteger[] cache) {
        if (n == 0) {
            return cache[0];
        }
        if (n == 1) {
            return cache[1];
        }
        if (cache[n].intValue() != -1) {
            return cache[n];
        }
        BigInteger result = fibonacci(n - 2, cache).add(fibonacci(n - 1, cache).multiply(fibonacci(n - 1, cache)));
        cache[n] = result;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(FibonacciModified.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/dynamicprogramming/fibonacci_modified.txt"));

        int t1 = in.nextInt();
        int t2 = in.nextInt();

        int n = in.nextInt();
        in.close();

        BigInteger[] cache = new BigInteger[n + 1];
        Arrays.fill(cache, BigInteger.valueOf(-1));
        cache[0] = BigInteger.valueOf(t1);
        cache[1] = BigInteger.valueOf(t2);

        System.out.println(fibonacci(n - 1, cache));
    }
}