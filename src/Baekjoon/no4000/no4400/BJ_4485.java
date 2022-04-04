package Baekjoon.no4000.no4400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4485 {
    private static int N;
    private static int[][] map, arr;
    private static class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    private static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        StringTokenizer st;


        StringBuilder sb = new StringBuilder();
        int tc = 1;

        while (true) {
            s = reader.readLine();
            st = new StringTokenizer(s);

            N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            map = new int[N][N];
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                s = reader.readLine();
                st = new StringTokenizer(s);
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs(0, 0);

            sb.append("Problem ").append(tc).append(": ").append(arr[N - 1][N - 1]).append("\n");
            tc++;
        }

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

    public static void bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col, map[row][col]));

        int _row, _col;
        Node node;

        while (!queue.isEmpty()) {
            node = queue.poll();

            for(int[] d : dir) {
                _row = node.row + d[0];
                _col = node.col + d[1];
                if (isIn(_row, _col) && arr[_row][_col] > node.val + map[_row][_col]) {
                    arr[_row][_col] = node.val + map[_row][_col];
                    queue.add(new Node(_row, _col, arr[_row][_col]));
                }
            }
        }
    }

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < N;
    }
}
