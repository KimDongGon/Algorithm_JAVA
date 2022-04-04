package SWExpertAcademy.no1000.no1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D6 {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        int N, answer, temp;
        int[][] arr, dp;

        for (int tc = 1; tc <= T; tc++) {
            s = reader.readLine();
            st = new StringTokenizer(s);

            answer = Integer.MAX_VALUE;

            N = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = arr[i][j] == 1 ? 1 : 1001;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                temp = 0;
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        temp += dp[i][j];
                    }
                }

                answer = Math.min(answer, temp);
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}
