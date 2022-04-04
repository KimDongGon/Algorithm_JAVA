package Baekjoon.no1000.no1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1194 {
    private static int N, M, MIN;
    private static char[][] arr;
    private static boolean[][][] visited;
    private static Queue<Node> queue;

    private static class Node {
        int row;
        int col;
        int val;
        int keys;

        public Node(int row, int col, int val, int keys) {
            this.row = row;
            this.col = col;
            this.val = val;
            this.keys = keys;
        }

        public boolean hasKey(char c) {
            return (keys & (1 << (c - 'a'))) != 0;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    ", val=" + val +
                    ", keys=" + keys +
                    '}';
        }
    }

    private static int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String[] st = s.split(" ");

        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);

        MIN = Integer.MAX_VALUE;

        arr = new char[N][M];
        visited = new boolean[64][N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            st = s.split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = st[j].charAt(0);

                if (arr[i][j] == '0') {
                    queue.add(new Node(i, j, 0, 0));
                    arr[i][j] = '.';
                }
            }
        }
        bfs();

        if (MIN == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(MIN);
        }
    }

    public static void bfs() {
        Node node;
        int _row, _col;
        char c;

        while (!queue.isEmpty()) {
            node = queue.poll();

            if (visited[node.keys][node.row][node.col]) {
                continue;
            }
            visited[node.keys][node.row][node.col] = true;

            for (int[] d : dir) {
                _row = node.row + d[0];
                _col = node.col + d[1];
                if (isIn(_row, _col) && !visited[node.keys][_row][_col] && arr[_row][_col] != '#') {
                    c = arr[_row][_col];
                    if (c == '1') {
                        MIN = Math.min(MIN, node.val + 1);
                        return;
                    } else if (c == '.') {
                        queue.add(new Node(_row, _col, node.val + 1, node.keys));
                    } else if ('A' <= c && c <= 'F') {
                        if (node.hasKey(Character.toLowerCase(c))) {
                            queue.add(new Node(_row, _col, node.val + 1, node.keys));
                        }
                    } else if ('a' <= c && c <= 'f') {
                        queue.add(new Node(_row, _col, node.val + 1, node.keys | (1 << (c - 'a'))));
                    }
                }
            }
        }
    }

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < M;
    }
}