package Baekjoon.no10000.no10000.no10400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10431 {
    private static int P, T, answer;
    private static int[] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        StringTokenizer st;

        sb = new StringBuilder();

        P = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= P; i++) {
            answer = 0;
            arr = new int[20];

            s = reader.readLine();
            st = new StringTokenizer(s);

            T = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            swap();

            sb.append(T).append(" ").append(answer).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static void swap() {
        int temp, cur;

        for (int i = 1; i < 20; i++) {
            cur = i;
            for (int j = cur - 1; j >= 0; j--) {
                if (arr[cur] < arr[j]) {
                    temp = arr[cur];
                    arr[cur] = arr[j];
                    arr[j] = temp;

                    cur = j;

                    answer++;
                }
            }
        }
    }
}
