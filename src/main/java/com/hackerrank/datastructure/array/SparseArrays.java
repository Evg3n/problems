package com.hackerrank.datastructure.array;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
public class SparseArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(SparseArrays.class.getClassLoader()
                .getResourceAsStream("datastructure/array/sparse_arrays.txt"));
        int inputSize = in.nextInt();
        in.nextLine();

        Map<String, Integer> strOccurrence = new HashMap<>();

        for (int i = 0; i < inputSize; i++) {
            String string = in.nextLine();
            if (strOccurrence.containsKey(string)) {
                strOccurrence.put(string, strOccurrence.get(string) + 1);
            } else {
                strOccurrence.put(string, 1);
            }
        }

        int queriesSize = in.nextInt();
        in.nextLine();

        List<String> queries = new ArrayList<>();
        for (int i = 0; i < queriesSize; i++) {
            queries.add(in.nextLine());
        }

        for (String q : queries) {
            int count = strOccurrence.containsKey(q) ? strOccurrence.get(q) : 0;
            System.out.println(count);
        }
    }
}
