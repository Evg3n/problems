package com.hackerrank.algorithm.string;

import com.hackerrank.datastructure.trie.Contacts;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/two-characters
 */
public class TwoCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(Contacts.class.getClassLoader().getResourceAsStream(
                "algorithm/string/two_characters.txt"));
        int length = in.nextInt();
        in.nextLine();
        System.out.println(getLongestValidString(in.nextLine()).length());
    }

    private static String getLongestValidString(String source) {
        if (source.isEmpty()) {
            return source;
        }
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < source.length(); i++) {
            uniqueChars.add(source.charAt(i));
        }

        String result = "";
        List<Character> chars = new ArrayList<>(uniqueChars);
        for (int i = 0; i < chars.size(); i++) {
            for (int j = i + 1; j < chars.size(); j++) {
                char char1 = chars.get(i);
                char char2 = chars.get(j);

                Set<Character> twoChars = new HashSet<>();
                twoChars.add(char1);
                twoChars.add(char2);

                if (twoChars.size() < 2) {
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                for (int j1 = 0; j1 < source.length(); j1++) {
                    Character currChar = source.charAt(j1);
                    if (twoChars.contains(currChar)) {
                        sb.append(currChar);
                    }
                }

                String currentResult = sb.toString();

                boolean isValid = isValidString(currentResult);
                if (isValid && result.length() < currentResult.length()) {
                    result = currentResult;
                }
            }
        }

        return result;
    }

    private static boolean isValidString(String source) {
        for (int i = 1; i < source.length(); i++) {
            if (source.charAt(i) == source.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }
}