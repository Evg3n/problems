package com.hackerrank.datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/jesse-and-cookies/problem
 */
public class JesseAndCookies {
    public static void main(String[] args) {
        Scanner in = new Scanner(JesseAndCookies.class.getClassLoader().getResourceAsStream(
                "datastructure/heap/jesse_and_cookies.txt"));

        int cookiesCount = in.nextInt();
        int sweetness = in.nextInt();
        in.nextLine();

        String cookiesStr = in.nextLine();

        Integer[] cookies;
        cookies = Arrays.stream(cookiesStr.split(" ")).map(Integer::valueOf).collect(Collectors.toList())
                .toArray(new Integer[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Arrays.asList(cookies));

        int opsCount = 0;
        while (queue.size() > 1) {
            if (queue.peek() > sweetness) {
                System.out.println(opsCount);
                return;
            }
            int currentSweetness = queue.poll() + queue.poll() * 2;
            queue.add(currentSweetness);
            opsCount++;
        }

        System.out.println(queue.peek() < sweetness ? -1 : opsCount);
    }
}