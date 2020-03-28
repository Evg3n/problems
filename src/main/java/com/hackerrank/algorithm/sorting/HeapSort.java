package com.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
  public static void main(String[] args) {
    Scanner in = new Scanner(HeapSort.class.getClassLoader().getResourceAsStream(
      "hackerrank/algorithm/sorting/heap_sort.txt"));

    int n = in.nextInt();

    int[] data = new int[n];

    for (int i = 0; i < n; i++) {
      data[i] = in.nextInt();
    }

    System.out.println(Arrays.toString(data));
    int[] result = heapSort(data);
    System.out.println(Arrays.toString(result));
  }

  private static int[] heapSort(int[] data) {
    buildheap(data);
    int sizeOfHeap = data.length - 1;
    for (int i = sizeOfHeap; i > 0; i--) {
      exchange(data, 0, i);
      sizeOfHeap = sizeOfHeap - 1;
      heapify(data, sizeOfHeap, 0);
    }
    return data;
  }

  private static void buildheap(int[] data) {
    for (int i = (data.length - 1) / 2; i >= 0; i--) {
      heapify(data, data.length - 1, i);
    }
  }

  private static void heapify(int[] data, int size, int i) {
    int left = i * 2 + 1;
    int right = i * 2 + 2;
    int max;

    if (left <= size && data[left] > data[i]) {
      max = left;
    } else {
      max = i;
    }

    if (right <= size && data[right] > data[max]) {
      max = right;
    }
    if (max != i) {
      exchange(data, i, max);
      heapify(data, size, max);
    }
  }

  private static void exchange(int[] data, int i, int j) {
    int t = data[i];
    data[i] = data[j];
    data[j] = t;
  }
}