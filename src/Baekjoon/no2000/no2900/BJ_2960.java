package Baekjoon.no2000.no2900;

import java.util.Scanner;

public class BJ_2960 {
    private static int N, K;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        visited = new boolean[N + 1];

        solve();
    }

    public static void solve() {
        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            if (!visited[i]) {
                for (int j = i; j <= N ; j += i) {
                    if (!visited[j]) {
                        visited[j] = true;
                        cnt++;
                        if (cnt == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}
