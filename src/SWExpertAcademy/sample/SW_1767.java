package SWExpertAcademy.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SW_1767 {
    private static int N, K;
    private static ArrayList<Node> list;
    private static int[] answer;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, 1 },
            { 0, -1 }
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
//        BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        int temp;

        for (int tc = 1; tc <= T; tc++) {
            answer = new int[12];
            Arrays.fill(answer, Integer.MAX_VALUE);

            temp = Integer.MAX_VALUE;

            s = reader.readLine();
            st = new StringTokenizer(s);

            N = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            visited = new boolean[N][N];
            list.clear();

            for (int i = 0; i < N; i++) {
                s = reader.readLine();
                st = new StringTokenizer(s);
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    if (arr[i][j] == 1) {
                        visited[i][j] = true;
                        if (!(i == 0 || i == N - 1 || j == 0 || j == N - 1)) {
                            list.add(new Node(i, j));
                        }
                    }
                }
            }

            K = list.size();

            dfs(0, 0, 0);

            for (int i = 11; i >= 0; i--) {
                if (answer[i] != Integer.MAX_VALUE) {
                    temp = answer[i];
                    break;
                }
            }

            sb.append("#").append(tc).append(" ").append(temp).append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

    public static void dfs(int cnt, int len, int process) {
        if (cnt == K) {
            answer[process] = Math.min(answer[process], len);
            return;
        }
        Node node = list.get(cnt);
        int temp;
        for(int[] d : dir) {
            temp = check(node.row, node.col, d);
            if (temp > 0) {
                change(node.row, node.col, d, true);
                dfs(cnt + 1, len + temp, process + 1);
                change(node.row, node.col, d, false);
            } else {
                dfs(cnt + 1, len, process);
            }
        }
    }

    public static void change(int row, int col, int[] d, boolean val) {
        while (row != 0 && row != N - 1 && col != 0 && col != N - 1) {
            row = row + d[0];
            col = col + d[1];

            visited[row][col] = val;
        }
    }

    public static int check(int row, int col, int[] d) {
        int temp = 0;
        while (row != 0 && row != N - 1 && col != 0 && col != N - 1) {
            row = row + d[0];
            col = col + d[1];

            if (arr[row][col] != 1 && !visited[row][col]) {
                temp++;
            } else {
                return 0;
            }
        }

        return temp;
    }
}
