package com.hackerrank.datastructure.disjointset;

import com.hackerrank.algorithm.sorting.CountingSort1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/components-in-graph
 */
public class ComponentsInAGraph {
    public static void main(String[] args) {
        Scanner in = new Scanner(CountingSort1.class.getClassLoader().getResourceAsStream(
                "datastructure/disjointset/components_in_a_graph.txt"));

        int count = in.nextInt();

        DisjointSet set = new DisjointSet(2 * count + 1);
        for (int i = 0; i < count; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();

            if (set.findSet(v1) == -1) {
                set.createSet(v1);
            }

            if (set.findSet(v2) == -1) {
                set.createSet(v2);
            }

            if (set.findSet(v1) != set.findSet(v2)) {
                set.mergeSets(v1, v2);
            }
        }

        System.out.println(set.getMinSize() + " " + set.getMaxSize());
    }

    private static class DisjointSet {
        private int[] data;

        DisjointSet(int size) {
            data = new int[size];
            Arrays.fill(data, -1);
        }

        void createSet(int representative) {
            data[representative] = representative;
        }

        int findSet(int member) {
            int representative = data[member];
            if (representative != -1) {
                while (representative != data[representative]) {
                    representative = data[representative];
                }
                data[member] = representative;
            }
            return representative;
        }

        void mergeSets(int firstMember, int secondMember) {
            int firstRepresentative = data[firstMember];
            int secondRepresentative = data[secondMember];

            if (firstRepresentative != -1) {
                while (firstRepresentative != data[firstRepresentative]) {
                    firstRepresentative = data[firstRepresentative];
                }
            }

            if (secondRepresentative != -1) {
                while (secondRepresentative != data[secondRepresentative]) {
                    secondRepresentative = data[secondRepresentative];
                }
            }

            if (firstRepresentative > secondRepresentative) {
                data[secondRepresentative] = firstRepresentative;
            } else {
                data[firstRepresentative] = secondRepresentative;
            }
        }

        int getMaxSize() {
            int max = Integer.MIN_VALUE;
            int[] sizes = countSizes();
            for (int i = 0; i < data.length; i++) {
                if (sizes[i] > max) {
                    max = sizes[i];
                }
            }
            return max;
        }

        int getMinSize() {
            int min = Integer.MAX_VALUE;
            int[] sizes = countSizes();
            for (int i = 0; i < data.length; i++) {
                if (sizes[i] > 1 && sizes[i] < min) {
                    min = sizes[i];
                }
            }
            return min;
        }

        int[] countSizes() {
            int[] sizes = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                int representative = findSet(i);
                if (representative != -1) {
                    sizes[representative] += 1;
                }
            }
            return sizes;
        }
    }
}