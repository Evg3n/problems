package com.hackerrank.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class AlgorithmicCrush {
    public static void main(String[] args) {
        Scanner in = new Scanner(AlgorithmicCrush.class.getClassLoader()
                .getResourceAsStream("hackerrank/datastructure/array/algorithmic_crush.txt"));
        int inputSize = in.nextInt();
        int querySize = in.nextInt();
        in.nextLine();

        List<Integer[]> operations = new ArrayList<>();
        for (int i = 0; i < querySize; i++) {
            String input = in.nextLine();
            String[] inoutParts = input.split(" ");

            Integer[] parts;
            parts = Arrays.stream(inoutParts).map(Integer::valueOf).collect(Collectors.toList())
                    .toArray(new Integer[0]);
            operations.add(parts);
        }

        Long[] prefixSum = new Long[inputSize + 1];
        for (int i = 0; i <= inputSize; i++) {
            prefixSum[i] = 0L;
        }

        for (Integer[] op : operations) {
            prefixSum[op[0] - 1] += op[2];
            prefixSum[op[1]] -= op[2];
        }

        Long sum = prefixSum[0];
        Long max = sum;
        for (int i = 1; i <= inputSize; i++) {
            sum += prefixSum[i];
            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}