package com.hackerrank.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/down-to-zero-ii/problem
 */
public class DownToZeroII {
    public static void main(String[] args) {
        Scanner in = new Scanner(DownToZeroII.class.getClassLoader()
                .getResourceAsStream("hackerrank/datastructure/queue/down_to_zero_ii.txt"));
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();

            int[] moves = new int[n + 1];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);

            while (!queue.isEmpty()) {
                Integer num = queue.poll();
                if (num == 0) {
                    break;
                }

                int b;
                for (int a = (int) Math.sqrt(num); a > 1; a--) {
                    if (num % a == 0) {
                        b = num / a;
                        if (moves[b] == 0) {
                            queue.add(b);
                            moves[b] = moves[num] + 1;
                        }
                    }
                }
                if (moves[num - 1] == 0) {
                    queue.add(num - 1);
                    moves[num - 1] = moves[num] + 1;
                }
            }
            System.out.println(moves[0]);
        }
    }
}
