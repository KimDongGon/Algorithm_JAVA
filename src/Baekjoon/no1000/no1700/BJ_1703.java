package Baekjoon.no1000.no1700;

import java.util.Scanner;

public class BJ_1703 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, answer;
        int s, c;
        while (true) {
            a = sc.nextInt();
            if (a == 0) {
                break;
            }
            answer = 1;
            for (int i = 0; i < a; i++) {
                s = sc.nextInt();
                c = sc.nextInt();

                answer *= s;
                answer -= c;
            }
            System.out.println(answer);
        }
    }
}
