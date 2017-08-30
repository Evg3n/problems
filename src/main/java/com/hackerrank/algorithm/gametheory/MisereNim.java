package com.hackerrank.algorithm.gametheory;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/misere-nim-1
 */
public class MisereNim {
    public static void main(String[] args) {
        Scanner in = new Scanner(MisereNim.class.getClassLoader().getResourceAsStream(
                "algorithm/gametheory/misere_nim.txt"));

        int gamesCount = in.nextInt();
        for (int i = 0; i < gamesCount; i++) {
            int pilesCount = in.nextInt();
            int[] piles = new int[pilesCount];
            for (int j = 0; j < pilesCount; j++) {
                piles[j] = in.nextInt();
            }

            System.out.println(getWinner(piles));
        }
    }

    private static String getWinner(int[] piles) {
        int lonelyPile = piles[0];
        int totalStones = piles[0];

        for (int i = 1; i < piles.length; i++) {
            lonelyPile ^= piles[i];
            totalStones += piles[i];
        }

        if (totalStones == piles.length) {
            return totalStones % 2 == 0 ? "First" : "Second";
        }

        return lonelyPile > 0 ? "First" : "Second";
    }
}