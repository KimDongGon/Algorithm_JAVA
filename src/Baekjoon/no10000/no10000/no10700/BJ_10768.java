package Baekjoon.no10000.no10000.no10700;

import java.util.Scanner;

public class BJ_10768 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int D = sc.nextInt();

        if (M < 2) {
            System.out.println("Before");
        } else if (M == 2) {
            if (D < 18) {
                System.out.println("Before");
            } else if (D == 18) {
                System.out.println("Special");
            } else {
                System.out.println("After");
            }
        } else {
            System.out.println("After");
        }
    }
}
