package Baekjoon.no20000.no24000.no24700;

import java.util.Scanner;

public class BJ_24736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            int T = sc.nextInt();
            int F = sc.nextInt();
            int S = sc.nextInt();
            int P = sc.nextInt();
            int C = sc.nextInt();

            System.out.println(T * 6 + F * 3 + S * 2 + P + C * 2);
        }
    }
}
