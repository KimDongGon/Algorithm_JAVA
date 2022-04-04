package Baekjoon.no10000.no16000.no16200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16234_인구이동_김동곤 {
    private static int N, L, R;
    private static int[][] arr, temp;
    private static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };
    private static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag;
        int row, col, sub, num, sum;
        int answer = 0;
        Node node;
        ArrayList<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        while (true) {

            flag = true;
            num = 0;
            temp = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (temp[i][j] == 0) {
                        queue.add(new Node(i, j));
                        temp[i][j] = ++num;
                        list.clear();
                        list.add(new Node(i, j));
                        sum = arr[i][j];

                        while (!queue.isEmpty()) {
                            node = queue.poll();
                            for (int[] d : dir) {
                                row = node.row + d[0];
                                col = node.col + d[1];

                                if (isIn(row, col) && temp[row][col] == 0) {
                                    sub = Math.abs(arr[node.row][node.col] - arr[row][col]);
                                    if (L <= sub && sub <= R) {
                                        temp[row][col] = temp[node.row][node.col];
                                        queue.add(new Node(row, col));
                                        list.add(new Node(row, col));
                                        sum += arr[row][col];
                                        flag = false;
                                    }
                                }
                            }
                        }

                        if (list.size() > 1) {
                            sum = sum / list.size();

                            for (int k = 0; k < list.size(); k++) {
                                node = list.get(k);

                                arr[node.row][node.col] = sum;
                            }
                        }
                    }
                }
            }

            if (flag) {
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < N;
    }

}