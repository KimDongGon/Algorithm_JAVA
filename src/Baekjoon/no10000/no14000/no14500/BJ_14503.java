package Baekjoon.no10000.no14000.no14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BJ_14503 {
    private static int N, M, answer;
    private static int[][] dir = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        s = reader.readLine();
        st = new StringTokenizer(s);

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(r, c, d);

        System.out.println(answer);
    }

    public static void solve(int r, int c, int d) {
        int _row, _col;
        int idx = d;
        boolean flag = true;

        if (arr[r][c] == 0) {
            arr[r][c] = 2;
            answer++;
        }

        for (int i = 0; i < 4; i++) {
            idx = idx > 0 ? idx - 1 : 3;
            _row = r + dir[idx][0];
            _col = c + dir[idx][1];
            if (isIn(_row, _col) && arr[_row][_col] == 0) {
                solve(_row, _col, idx);
                flag = false;
                break;
            }
        }

        if (flag) {
            _row = r - dir[idx][0];
            _col = c - dir[idx][1];
            if (isIn(_row, _col) && arr[_row][_col] != 1) {
                solve(_row, _col, idx);
            }
        }
    }

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < M;
    }
}
