package Baekjoon.no2000.no2500;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2567 {
    private static int[][] arr;
    private static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[101][101];
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            for (int j = A; j < A + 10; j++) {
                for (int k = B; k < B + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (arr[i][j] == 1) {
                    int num = check(i, j);
                    answer += num;
                }
            }
        }

        System.out.println(answer);
    }

    public static int check(int row, int col) {
        int _row, _col;
        int cnt = 0;
        for (int[] d : dir) {
            _row = row + d[0];
            _col = col + d[1];
            if (isIn(_row, _col) && arr[_row][_col] == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < 101 && 0 <= col && col < 101;
    }
}
