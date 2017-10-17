package com.hackerrank.algorithm.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/grading
 */
public class GradingStudents {
    public static void main(String[] args) {
        Scanner in = new Scanner(GradingStudents.class.getClassLoader().getResourceAsStream(
                "hackerrank/algorithm/implementation/grading_students.txt"));
        int gradesCount = in.nextInt();

        for (int i = 0; i < gradesCount; i++) {
            System.out.println(applyPolicy(in.nextInt()));
        }
    }

    private static int applyPolicy(int sourceGrade) {
        int resultGradle = sourceGrade;
        if (resultGradle >= 38) {
            int timesFive = resultGradle / 5;

            if (resultGradle % 5 >= 3) {
                resultGradle = (timesFive + 1) * 5;
            }
        }
        return resultGradle;
    }
}