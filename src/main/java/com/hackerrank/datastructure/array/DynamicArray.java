package com.hackerrank.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/dynamic-array/problem
 */
public class DynamicArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(DynamicArray.class.getClassLoader()
                .getResourceAsStream("datastructure/array/dynamic_array.txt"));
        int seqSize = in.nextInt();
        int queriesCount = in.nextInt();
        in.nextLine();

        List<Integer[]> queries = new ArrayList<>();
        for (int i = 0; i < queriesCount; i++) {
            String query = in.nextLine();
            String[] inoutParts = query.split(" ");
            Integer[] parts;
            parts = Arrays.stream(inoutParts).map(Integer::valueOf).collect(Collectors.toList())
                    .toArray(new Integer[0]);
            queries.add(parts);
        }

        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < seqSize; i++) {
            seqList.add(new ArrayList<>());
        }

        int lastAnswer = 0;

        for (Integer[] q : queries) {
            int seqIndex = ((q[1] ^ lastAnswer) % seqSize);
            switch (q[0]) {
                case 1:
                    seqList.get(seqIndex).add(q[2]);
                    break;
                case 2:
                    int valueIndex = q[2] % seqList.get(seqIndex).size();
                    lastAnswer = seqList.get(seqIndex).get(valueIndex);
                    System.out.println(lastAnswer);
                    break;
            }
        }
    }
}