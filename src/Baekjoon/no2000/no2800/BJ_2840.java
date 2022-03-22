package Baekjoon.no2000.no2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2840 {
    private static int N;
    private static char[] arr;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int S, idx = 0;
        char C;
        boolean flag = true;

        arr = new char[N];
        visited = new boolean[26];

        for (int i = 0; i < N; i++) {
            arr[i] = '?';
        }

        for (int i = 0; i < K; i++) {
            s = reader.readLine();
            st = new StringTokenizer(s);
            
            S = Integer.parseInt(st.nextToken());
            C = st.nextToken().charAt(0);
            
            if (i == 0) {
                arr[0] = C;
            } else {
                if ((arr[makeIdx(idx - S)] == '?' || arr[makeIdx(idx - S)] == C)) {
                    arr[makeIdx(idx - S)] = C;
                    idx = makeIdx(idx - S);
                } else {
                    flag = false;
                    break;
                }
            }
        }
        
        if (flag) {
            if (check()) {
                for (int i = 0; i < N; i++) {
                    System.out.print(arr[idx]);
                    idx = makeIdx(idx + 1);
                }
            } else {
                System.out.println('!');
            }
        } else {
            System.out.println('!');
        }
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            if (arr[i] != '?') {
                if (visited[arr[i] - 'A']) {
                    return false;
                } else {
                    visited[arr[i] - 'A'] = true;
                }
            }
        }
        return true;
    }
    
    public static int makeIdx(int idx) {
        if (idx < 0) {
            while (idx < 0) {
                idx += N;
            }
            return idx;
        } else if (idx > 0) {
            if (idx >= N) {
                return idx % N;
            } else {
                return idx;
            }
        } else {
            return idx;
        }
    }
}
