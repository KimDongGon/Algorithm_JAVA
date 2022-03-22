package Baekjoon.no1000.no1900;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1991 {
    private static int N;
    private static StringBuilder sb;
    private static Node[] arr;
    private static class Node {
        char left;
        char right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        sb = new StringBuilder();
        arr = new Node[26];

        char root, left, right;
        for (int i = 0; i < N; i++) {
            root = sc.next().charAt(0);
            left = sc.next().charAt(0);
            right = sc.next().charAt(0);

            arr[root - 'A'] = new Node(left, right);
        }

        preorder('A');
        sb.append("\n");

        inorder('A');
        sb.append("\n");

        postorder('A');
        System.out.print(sb);
    }

    public static void preorder(char ch) {
        Node node = arr[ch - 'A'];
        sb.append(ch);
        if (node.left != '.') {
            preorder(node.left);
        }
        if (node.right != '.') {
            preorder(node.right);
        }
    }

    public static void inorder(char ch) {
        Node node = arr[ch - 'A'];
        if (node.left != '.') {
            inorder(node.left);
        }
        sb.append(ch);
        if (node.right != '.') {
            inorder(node.right);
        }
    }

    public static void postorder(char ch) {
        Node node = arr[ch - 'A'];
        if (node.left != '.') {
            postorder(node.left);
        }
        if (node.right != '.') {
            postorder(node.right);
        }
        sb.append(ch);
    }
}
