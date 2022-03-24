package Baekjoon.no1000.no1400;

import java.util.Scanner;

public class BJ_1434 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[M];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (B[i] <= A[j]) {
                    A[j] -= B[i];
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer += A[i];
        }

        System.out.println(answer);
    }
}
