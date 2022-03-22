package Baekjoon.no10000.no14000.no14800;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_14889 {
    private static int N, MIN;
    private static int[][] arr;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        MIN = Integer.MAX_VALUE;
        visited = new boolean[N];

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solve(0, 0);

        System.out.println(MIN);
    }

    public static void solve(int cnt, int start) {
        if (cnt == N / 2) {
            int sTeam = 0;
            int lTeam = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        if (visited[i] && visited[j]) {
                            sTeam += arr[i][j];
                        } else if (!visited[i] && !visited[j]) {
                            lTeam += arr[i][j];
                        }
                    }
                }
            }
            MIN = Math.min(MIN, Math.abs(sTeam - lTeam));
            return;
        }

        for (int i = start; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            solve(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}
