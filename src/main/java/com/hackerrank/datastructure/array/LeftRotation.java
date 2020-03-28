package com.hackerrank.datastructure.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 */
public class LeftRotation {
  public static void main(String[] args) {
    Scanner in = new Scanner(LeftRotation.class.getClassLoader()
      .getResourceAsStream("hackerrank/datastructure/array/left_rotation.txt"));
    int arraySize = in.nextInt();
    int rotationCount = in.nextInt();
    in.nextLine();
    String arrayStr = in.nextLine();

    String[] strings = arrayStr.split(" ");

    Integer[] array;
    array = Arrays.stream(strings).map(Integer::valueOf).toArray(Integer[]::new);

    Integer[] rotatedArray = new Integer[rotationCount];
    for (int i = 0; i < rotationCount; i++) {
      rotatedArray[i] = array[i];
    }

    for (int i = rotationCount; i < arraySize; i++) {
      array[i - rotationCount] = array[i];
    }

    for (int i = 0; i < rotationCount; i++) {
      array[i + arraySize - rotationCount] = rotatedArray[i];
    }

    for (int i = 0; i < arraySize - 1; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println(array[arraySize - 1]);
  }
}