package Baekjoon.no2000.no2900;

import java.util.Scanner;

public class BJ_2947 {
    private static int[] arr = new int[5];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        while (true) {
            if (check()) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    print();
                }
            }
        }
    }

    public static boolean check() {
        for (int i = 0; i < 5; i++) {
            if (arr[i] != (i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
