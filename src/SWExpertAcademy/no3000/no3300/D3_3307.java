package SWExpertAcademy.no3000.no3300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_3307 {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        int N, answer;
        int[] arr, dp;

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(reader.readLine());

            answer = 1;

            arr = new int[N];
            dp = new int[N];

            Arrays.fill(dp, 1);

            s = reader.readLine();
            st = new StringTokenizer(s);

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] >= arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                answer = Math.max(answer, dp[i]);
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
