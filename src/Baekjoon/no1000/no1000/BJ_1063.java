package Baekjoon.no1000.no1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);
        String[] str;

        str = st.nextToken().split("");
        int kingR = 9 - Integer.parseInt(str[1]);
        int kingC = str[0].charAt(0) - 'A' + 1;

        str = st.nextToken().split("");
        int dolR = 9 - Integer.parseInt(str[1]);
        int dolC = str[0].charAt(0) - 'A' + 1;

        int N = Integer.parseInt(st.nextToken());
        int[] d;
        int _kingR, _kingC, _dolR, _dolC;

        for (int i = 0; i < N; i++) {
            s = reader.readLine();
            d = calDir(s);

            _kingR = kingR + d[0];
            _kingC = kingC + d[1];

            if (isIn(_kingR, _kingC)) {
                if (_kingR == dolR && _kingC == dolC) {
                    _dolR = dolR + d[0];
                    _dolC = dolC + d[1];

                    if (isIn(_dolR, _dolC)) {
                        dolR = _dolR;
                        dolC = _dolC;

                        kingR = _kingR;
                        kingC = _kingC;
                    }
                } else {
                    kingR = _kingR;
                    kingC = _kingC;
                }
            }
        }

        sb.append((char)('A' + kingC - 1)).append(9 - kingR);
        sb.append("\n");
        sb.append((char)('A' + dolC - 1)).append(9 - dolR);
        System.out.println(sb);
    }

    public static int[] calDir(String s) {
        if (s.equals("R")) {
            return new int[] { 0, 1 };
        } else if (s.equals("L")) {
            return new int[] { 0, -1 };
        } else if (s.equals("B")) {
            return new int[] { 1, 0 };
        } else if (s.equals("T")) {
            return new int[] { -1, 0 };
        }
        else if (s.equals("RT")) {
            return new int[] { -1, 1 };
        } else if (s.equals("LT")) {
            return new int[] { -1, -1 };
        } else if (s.equals("RB")) {
            return new int[] { 1, 1 };
        } else if (s.equals("LB")) {
            return new int[] { 1, -1 };
        }
        return null;
    }

    public static boolean isIn(int row, int col) {
        return 0 < row && row < 9 && 0 < col && col < 9;
    }
}
