package Baekjoon.no10000.no14000.no14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14502 {
    private static int N, M, MAX;
    private static int[][] arr, temp;
    private static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, 1 },
            { 0, -1 }
    };
    private static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        MAX = Integer.MIN_VALUE;

        arr = new int[N][M];
        temp = new int[N][M];

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    list.add(new int[] { i, j });
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < M; l++) {
                        for (int m = 0; m < N; m++) {
                            for (int n = 0; n < M; n++) {
                                if (((i != k) || (j != l)) && ((k != m) || (l != n)) && ((i != m) || (j != n))) {
                                    if (arr[i][j] == 0 && arr[k][l] == 0 && arr[m][n] == 0) {
                                        init();
                                        temp[i][j] = 1;
                                        temp[k][l] = 1;
                                        temp[m][n] = 1;
                                        solve();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(MAX);
    }

    public static void solve() {
        Queue<int[]> queue = new LinkedList<>(list);
        int[] cur;
        int _row, _col;

        while (!queue.isEmpty()) {
            cur = queue.poll();

            for (int[] d : dir) {
                _row = cur[0] + d[0];
                _col = cur[1] + d[1];

                if (isIn(_row, _col) && temp[_row][_col] == 0) {
                    temp[_row][_col] = 2;
                    queue.add(new int[] { _row, _col });
                }
            }
        }

        count();
    }

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < M;
    }

    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = arr[i][j];
            }
        }
    }

    public static void count() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        MAX = Math.max(MAX, cnt);
    }
}
