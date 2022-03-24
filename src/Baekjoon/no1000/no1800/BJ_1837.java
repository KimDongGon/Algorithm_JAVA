package Baekjoon.no1000.no1800;
import java.util.Scanner;

public class BJ_1837 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] p = sc.next().toCharArray();
        int k = sc.nextInt();

        boolean flag = true;
        int answer = 0;

        for (int i = 2; i < k; i++) {
            if (check(p, i)) {
                flag = false;
                answer = i;
                break;
            }
        }

        if (flag) {
            System.out.println("GOOD");
        } else {
            System.out.println("BAD " + answer);
        }
    }

    public static boolean check(char[] p, int q) {
        int result = 0;
        for (int i = 0; i < p.length; i++) {
            result = (result * 10 + (p[i] - '0')) % q;
        }

        return result == 0;
    }
}
