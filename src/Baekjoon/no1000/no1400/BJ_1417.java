package Baekjoon.no1000.no1400;

import java.util.Scanner;

public class BJ_1417 {
    private static int N;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0, idx;

        while (!check()) {
            idx = findMaxIdx();
            arr[idx]--;
            arr[0]++;

            answer++;
        }

        System.out.println(answer);
    }

    public static int findMaxIdx() {
        int idx = 1, MAX = Integer.MIN_VALUE;

        for (int i = 1; i < N; i++) {
            if (MAX < arr[i]) {
                MAX = arr[i];
                idx = i;
            }
        }

        return idx;
    }

    public static boolean check() {
        for (int i = 1; i < N; i++) {
            if (arr[0] <= arr[i]) {
                return false;
            }
        }
        return true;
    }
}
