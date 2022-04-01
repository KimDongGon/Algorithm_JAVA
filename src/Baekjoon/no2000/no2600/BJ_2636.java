package Baekjoon.no2000.no2600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2636 {
    private static int N, M, answer, cheese;
    private static int[][] arr, temp;
    private static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, 1 },
            { 0, -1 }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    cheese++;
                }
            }
        }

        solve();
    }

    public static void solve() {
        dfs(0, 0);

        int row, col;
        int cnt = cheese;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                boolean flag = true;
                for (int[] d : dir) {
                    row = i + d[0];
                    col = j + d[1];
                    if (isIn(row, col) && arr[i][j] == 1 && arr[row][col] == 2) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    temp[i][j] = arr[i][j];
                } else {
                    temp[i][j] = 2;
                    cnt--;
                }
            }
        }

        if (cnt == 0) {
            System.out.println(answer + 1);
            System.out.println(cheese);
        } else {
            cheese = cnt;
            answer++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] == 2)
                        arr[i][j] = 0;
                    else
                        arr[i][j] = temp[i][j];
                }
            }
            solve();
        }
    }

    public static void dfs(int row, int col) {
        int _row, _col;
        for (int[] d : dir) {
            _row = row + d[0];
            _col = col + d[1];

            if (isIn(_row, _col) && arr[_row][_col] == 0) {
                arr[_row][_col] = 2;
                dfs(_row, _col);
            }
        }
    }

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < M;
    }
}
