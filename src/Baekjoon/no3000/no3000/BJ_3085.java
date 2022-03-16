package Baekjoon.no3000.no3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3085 {
    private static int N;
    private static char[][] arr;
    private static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };
    private static int MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        String[] st;

        N = Integer.parseInt(reader.readLine());
        arr = new char[N][N];
        MAX = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            st = s.split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = st[j].charAt(0);
            }
        }

        solve();

        System.out.println(MAX);
    }

    public static void solve() {
        int _row, _col;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int[] d : dir) {
                    _row = r + d[0];
                    _col = c + d[1];

                    if (isIn(_row, _col)) {
                        swap(r, c, _row, _col);
                        check(r, c);
                        check(_row, _col);
                        swap(r, c, _row, _col);
                    }
                }
            }
        }
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

    public static void check(int row, int col) {
        int answer = 1;


        char val = arr[row][0];
        for (int i = 1; i < N; i++) {
            if (val == arr[row][i]) {
                answer++;
            } else {
                val = arr[row][i];
                MAX = Math.max(MAX, answer);
                answer = 1;
            }
        }
        MAX = Math.max(MAX, answer);

        answer = 1;
        val = arr[0][col];
        for (int i = 1; i < N; i++) {
            if (val == arr[i][col]) {
                answer++;
            } else {
                val = arr[i][col];
                MAX = Math.max(MAX, answer);
                answer = 1;
            }
        }
        MAX = Math.max(MAX, answer);
    }

    public static void swap(int row, int col, int _row, int _col) {
        char temp;

        temp = arr[row][col];
        arr[row][col] = arr[_row][_col];
        arr[_row][_col] = temp;
    }

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < N;
    }
}
