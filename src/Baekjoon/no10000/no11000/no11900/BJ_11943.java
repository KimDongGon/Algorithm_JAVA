package Baekjoon.no10000.no11000.no11900;

import java.util.Scanner;

public class BJ_11943 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        int answer = Math.min(A + D, B + C);
        System.out.println(answer);
    }
}
