package Baekjoon.no1000.no1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1091 {
    private static int N, answer;
    private static int[] C, P, S, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st;

        N = Integer.parseInt(s);

        C = new int[N];
        P = new int[N];
        S = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            C[i] = i % 3;
        }

        s = reader.readLine();
        st = new StringTokenizer(s);
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        s = reader.readLine();
        st = new StringTokenizer(s);
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());

        }

        while (true) {
            if (check()) {
                break;
            }

            shuffle();

            answer++;

            if (answer > 1000000) {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
    }

    public static void shuffle() {
        for (int i = 0; i < N; i++) {
            temp[S[i]] = P[i];
        }

        System.arraycopy(temp, 0, P, 0, P.length);
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            if (C[i] != P[i])
                return false;
        }
        return true;
    }
}