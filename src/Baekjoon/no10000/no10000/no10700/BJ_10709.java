package Baekjoon.no10000.no10000.no10700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10709 {
    private static int H, W, cnt;
    private static char[][] arr;
    private static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String[] str;
        StringTokenizer st = new StringTokenizer(s);

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new char[H][W];
        visited = new int[H][W];

        for (int i = 0; i < H; i++) {
            s = reader.readLine();
            str = s.split("");
            for (int j = 0; j < W; j++) {
                arr[i][j] = str[j].charAt(0);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == 'c') {
                    visited[i][j] = 0;
                } else {
                    visited[i][j] = -1;
                }
            }
        }

        while (check()) {
            cnt++;
            move();
        }

        print(visited);
    }

    public static void move() {
        for (int i = 0; i < H; i++) {
            for (int j = W - 1; j > 0; j--) {
                arr[i][j] = arr[i][j - 1];
                if (arr[i][j] == 'c' && visited[i][j] == -1) {
                    visited[i][j] = cnt;
                }
            }
            arr[i][0] = '.';
        }
    }

    public static boolean check() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == 'c') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void print(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
