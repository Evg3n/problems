package com.hackerrank.datastructure.stack;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/equal-stacks/problem
 */
public class EqualStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(EqualStacks.class.getClassLoader()
                .getResourceAsStream("datastructure/stack/equal_stacks.txt"));
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
        }

        System.out.println(getMaxHeight(h1, h2, h3));
    }

    private static int getMaxHeight(int[] stack1, int[] stack2, int[] stack3) {
        int height1 = 0;
        int height2 = 0;
        int height3 = 0;

        for (int i : stack1) {
            height1 += i;
        }
        for (int i : stack2) {
            height2 += i;
        }
        for (int i : stack3) {
            height3 += i;
        }

        if (height1 == height2 && height2 == height3) {
            return height1;
        }

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (height1 != height2 || height2 != height3) {
            while (height1 > height2 || height1 > height3) {
                height1 -= stack1[index1++];
            }

            while (height2 > height1 || height2 > height3) {
                height2 -= stack2[index2++];
            }

            while (height3 > height1 || height3 > height2) {
                height3 -= stack3[index3++];
            }
        }

        return height1;
    }
}