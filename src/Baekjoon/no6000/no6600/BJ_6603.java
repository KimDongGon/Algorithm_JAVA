package Baekjoon.no6000.no6600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6603 {
    private static int k;
    private static int[] arr;
    private static boolean[] visitied;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        StringTokenizer st;

        sb = new StringBuilder();

        while(true) {
            s = reader.readLine();
            st = new StringTokenizer(s);
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            arr = new int[k];
            visitied = new boolean[k];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);

            System.out.println(sb);
            sb.setLength(0);
        }
    }

    public static void comb(int cnt, int start) {
        if (cnt == 6) {
            for (int i = 0; i < k; i++) {
                if (visitied[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if (visitied[i]) continue;
            visitied[i] = true;
            comb(cnt + 1, i + 1);
            visitied[i] = false;
        }
    }
}
