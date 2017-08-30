package com.hackerrank.algorithm.gametheory;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/nim-game-1
 */
public class IntroductionToNimGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(IntroductionToNimGame.class.getClassLoader().getResourceAsStream(
                "algorithm/gametheory/introduction_to_nim_game.txt"));

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

        for (int i = 1; i < piles.length; i++) {
            lonelyPile ^= piles[i];
        }

        return lonelyPile != 0 ? "First" : "Second";
    }
}