package Baekjoon.no2000.no2900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2980 {
    private static class Light {
        int pos;
        int R;
        int G;

        public Light(int pos, int r, int g) {
            this.pos = pos;
            R = r;
            G = g;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Light[] lights = new Light[N];

        int D, R, G;

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            st = new StringTokenizer(s);

            D = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

            lights[i] = new Light(D, R, G);
        }

        int dis = 0;
        int time = 0;
        int idx = 0;

        while (dis < L) {
            if (idx == N) {
                time += L - dis;
                break;
            }
            if (lights[idx].pos == dis) {
                // 빨간불
                int cur = time % (lights[idx].R + lights[idx].G);
                if (0 <= cur && cur <= lights[idx].R) {
                    time += lights[idx].R - cur + 1;
                }
                // 파란불
                else {
                    time++;
                }
                    idx ++; // 다음 신호등
            } else {
                time++;
            }
            dis++;
        }

        System.out.println(time);
    }
}
