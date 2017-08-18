package com.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1
 */
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(CaesarCipher.class.getClassLoader().getResourceAsStream(
                "algorithm/string/caesar_cipher.txt"));
        int length = in.nextInt();
        String source = in.next();
        int rotation = in.nextInt();

        System.out.println(encode(source, rotation));
    }

    private static String encode(String source, int rotation) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'Z') {
                sb.append((char) ((currentChar - 'A' + rotation) % 26 + 'A'));
            } else if (currentChar >= 'a' && currentChar <= 'z') {
                sb.append((char) ((currentChar - 'a' + rotation) % 26 + 'a'));
            } else {
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }
}