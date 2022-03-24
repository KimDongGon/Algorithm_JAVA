package Baekjoon.no1000.no1000;

import java.util.Scanner;

public class BJ_1059 {
    private static int L, n, answer;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        arr = new int[L];

        for (int i = 0; i < L; i++) {
            arr[i] = sc.nextInt();
        }

        n = sc.nextInt();

        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < L; i++) {
            right = Math.max(right, arr[i]);
        }

        for (int i = left; i < right; i++) {
            for (int j = n; j < right; j++) {
                boolean flag = true;
                for (int k = 0; k < L; k++) {
                    if (i >= j || i <= arr[k] && arr[k] <= j || i > n) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
