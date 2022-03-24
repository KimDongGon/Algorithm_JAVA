package Baekjoon.no1000.no1200;

import java.util.Scanner;

public class BJ_1252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 81 - a.length; i++) {
            sb.append('0');
        }
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
        a = sb.toString().toCharArray();
        sb.setLength(0);

        for (int i = 0; i < 81 - b.length; i++) {
            sb.append('0');
        }
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        b = sb.toString().toCharArray();


        int _a, _b, c = 0, temp;
        StringBuilder s = new StringBuilder();

        for (int i = 80; i >= 0; i--) {
            _a = a[i] - '0';
            _b = b[i] - '0';
            temp = _a + _b + c;
            if (temp == 0) {
                c = 0;
                s.append("0");
            } else if (temp == 1) {
                c = 0;
                s.append("1");
            } else if (temp == 2) {
                c = 1;
                s.append("0");
            } else if (temp == 3) {
                c = 1;
                s.append("1");
            }
        }
        s.setLength(s.lastIndexOf("1") + 1);
        s.reverse();
        if (s.length() > 0) {
            System.out.println(s);
        } else {
            System.out.println(0);
        }
    }
}
