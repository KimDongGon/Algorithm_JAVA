package Baekjoon.no3000.no3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3060 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        StringTokenizer st;

        int T = Integer.parseInt(reader.readLine());

        int N, answer;
        long idx, feed, sum;
        long[] arr;
        Queue<long[]> queue;
        long[] pig;

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(reader.readLine());
            answer = 0;
            sum = 0;
            arr = new long[6];
            queue = new LinkedList<>();

            s = reader.readLine();
            st = new StringTokenizer(s);

            for (int j = 0; j < 6; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                queue.add(new long[]{j, arr[j]});
                sum += arr[j];
            }

            while (true) {
                if (sum > N) {
                    System.out.println(answer + 1);
                    break;
                }

                sum = 0;

                for (int j = 0; j < 6; j++) {
                    pig = queue.poll();
                    idx = pig[0];
                    feed = pig[1];

                    feed += arr[(int) (idx + 1) % 6] + arr[(int) (idx + 5) % 6] + arr[(int) (idx + 3) % 6];
                    queue.add(new long[] { idx, feed });
                }

                for (int j = 0; j < 6; j++) {
                    pig = queue.poll();
                    idx = pig[0];
                    feed = pig[1];

                    arr[(int) idx] = feed;
                    sum += arr[(int) idx];
                }

                for (int j = 0; j < 6; j++) {
                    queue.add(new long[]{j, arr[j]});
                }
                answer++;
            }
        }
    }
}
