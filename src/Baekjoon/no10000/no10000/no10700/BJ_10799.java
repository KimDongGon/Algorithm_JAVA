package Baekjoon.no10000.no10000.no10700;

import java.util.Scanner;

public class BJ_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split("");

        int[] arr = new int[100000];
        int idx = -1;

        int answer = 0;
        int top;

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("(")) {
                arr[++idx] = 1;
            } else {
                top = arr[idx];
                if (top == 1) {
                    for (int j = 0; j < idx; j++) {
                        arr[j]++;
                    }
                } else {
                    answer += top;
                }
                idx--;
            }
        }
        System.out.println(answer);
    }
}
