package Baekjoon.no1000.no1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            s = reader.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) { // dp
                for (int k = 0; k < 3; k++) {
                    if (j != k && dp[i][j] > dp[i - 1][k] + arr[i][k]) {
                        dp[i][j] = dp[i - 1][k] + arr[i][k];
                    }
                }
            }
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), Math.min(dp[N][1], dp[N][2])));
    }
}
