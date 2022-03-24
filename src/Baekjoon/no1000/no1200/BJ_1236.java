package Baekjoon.no1000.no1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String[] st = s.split(" ");

        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        boolean[] rVisited = new boolean[N];
        boolean[] cVisited = new boolean[M];

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            st = s.split("");
            for (int j = 0; j < M; j++) {
                if (st[j].equals("X")) {
                    rVisited[i] = true;
                    cVisited[j] = true;
                }
            }
        }

        int rCnt = 0, cCnt = 0;

        for (int i = 0; i < N; i++) {
            if (!rVisited[i]) {
                rCnt ++;
            }
        }
        for (int i = 0; i < M; i++) {
            if (!cVisited[i]) {
                cCnt ++;
            }
        }

        System.out.println(Math.max(rCnt, cCnt));
    }
}
