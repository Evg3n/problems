package com.hackerrank.datastructure.tree;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/tree-huffman-decoding
 */
public class HuffmanDecoding {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    Node b = new Node('B', 1);
    Node c = new Node('C', 1);
    Node bc = new Node('\0', 2, b, c);

    Node a = new Node('A', 3);
    Node root = new Node('\0', 5, bc, a);

    decode(in.nextLine(), root);
  }

  private static void decode(String s, Node root) {
    Node currentNode = root;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        currentNode = currentNode.left;
      } else { // 1
        currentNode = currentNode.right;
      }
      if (currentNode.data != '\0') {
        System.out.print(currentNode.data);
        currentNode = root;
      }
    }
  }

  static class Node {
    char data;
    int frequency;
    Node left;
    Node right;

    Node(char data, int frequency) {
      this.data = data;
      this.frequency = frequency;
    }

    Node(char data, int frequency, Node left, Node right) {
      this(data, frequency);
      this.left = left;
      this.right = right;
    }
  }
}