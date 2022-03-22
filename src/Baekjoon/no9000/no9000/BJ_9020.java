package Baekjoon.no9000.no9000;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_9020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] visited = new boolean[10001];

        visited[0] = visited[1] = true;

        for (int i = 2; i < 10001; i++) {
            if (!visited[i]) {
                for (int j = i + i; j < 10001; j += i) {
                    visited[j] = true;
                }
            }
        }

        int T = sc.nextInt();
        int n, idx, MIN;
        int[] k;
        ArrayList<int[]> list = new ArrayList<>();

        for (int tc = 0; tc < T; tc++) {
            n = sc.nextInt();
            idx = 0;
            MIN = Integer.MAX_VALUE;
            for (int i = 2; i <= n / 2; i++) {
                if (!visited[i] && !visited[n - i]) {
                    list.add(new int[] {i, n - i});
                }
            }

            for (int i = 0; i < list.size(); i++) {
                k = list.get(i);
                if (MIN > k[1] - k[0]) {
                    MIN = k[1] - k[0];
                    idx = i;
                }
            }

            System.out.println(list.get(idx)[0] + " " + list.get(idx)[1]);

            list.clear();
        }
    }
}
