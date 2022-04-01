package Baekjoon.no1000.no1400;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int[] dp = new int[X + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[X] = 0;

        for (int i = X; i >= 1; i--) {
            if (i % 3 == 0) {
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            }
            if (i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            }
            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
        }

        System.out.println(dp[1]);
    }
}
