package Baekjoon.no1000.no1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600 {
    private static int N, M;
    private static int[][] arr;
    private static boolean[][][] visited;
    private static int[][] horse = {
            { -1, -2 },
            { -2, -1 },
            { -2, 1 },
            { -1, 2 },
            { 1, 2 },
            { 2, 1 },
            { 2, -1 },
            { 1, -2 }
    };
    private static int[][] monkey = {
            { -1, 0 },
            { 0, 1 },
            { 1, 0 },
            { 0, -1 }
    };
    private static class Monkey {
        int row;
        int col;
        int cnt;
        int k;

        public Monkey(int row, int col, int cnt, int k) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.k = k;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int K = Integer.parseInt(st.nextToken());

        s = reader.readLine();
        st = new StringTokenizer(s);

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[K + 1][N][M];

        Queue<Monkey> queue = new LinkedList<>();
        queue.add(new Monkey(0, 0, 0, K));
        Monkey m;
        int row, col;

        while (!queue.isEmpty()) {
            m = queue.poll();

            if (m.row == N - 1 && m.col == M - 1) {
                System.out.println(m.cnt);
                return;
            }

            if (m.k > 0) {
                for (int[] d : horse) {
                    row = m.row + d[0];
                    col = m.col + d[1];
                    if (isIn(row, col) && arr[row][col] == 0 && !visited[m.k - 1][row][col]) {
                        queue.add(new Monkey(row, col, m.cnt + 1, m.k - 1));
                        visited[m.k - 1][row][col] = true;
                    }
                }
            }
            for (int[] d : monkey) {
                row = m.row + d[0];
                col = m.col + d[1];
                if (isIn(row, col) && arr[row][col] == 0 && !visited[m.k][row][col]) {
                    queue.add(new Monkey(row, col, m.cnt + 1, m.k));
                    visited[m.k][row][col] = true;
                }
            }
        }

        System.out.println(-1);
    }

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < M;
    }
}
