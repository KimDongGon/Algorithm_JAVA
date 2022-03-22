package Baekjoon.no1000.no1900;

import java.util.Scanner;

public class BJ_1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[1000001];

        dp[1] = 1; // 1
        dp[2] = 2; // 00, 11
        dp[3] = 3; // 001, 100, 111
        dp[4] = 5; // 0000, 0011, 1001, 1100, 1111

        for (int i = 5; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[N]);
    }
}
