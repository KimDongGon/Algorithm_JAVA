package Baekjoon.no10000.no12000.no12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12100 {
    private static int N;
    private static int MAX;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        StringTokenizer st;

        N = Integer.parseInt(reader.readLine());

        int[][] arr = new int[N][N];

        MAX = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            st = new StringTokenizer(s);

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, arr);

        System.out.println(MAX);
    }

    public static void bfs(int cnt, int[][] arr) {
        if (cnt == 5) {
            MAX = Math.max(MAX, findMax(arr));
            return;
        }

        for (int i = 0; i < 4; i++) {
            bfs(cnt + 1, sweep(arr));
        }
    }

    public static int[][] sweep(int[][] arr) {
        return arr;
    }

    public static int findMax(int[][] arr) {
        int MAX = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                MAX = Math.max(MAX, arr[i][j]);
            }
        }

        return MAX;
    }
}
