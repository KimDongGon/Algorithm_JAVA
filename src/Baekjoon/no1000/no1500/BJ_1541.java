package Baekjoon.no1000.no1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BJ_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] str = s.split("-");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(str));

        int l = list.size();
        int a, b;
        ArrayList<Integer> iList = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            str = list.get(i).split("\\+");
            if (str.length == 1) {
                iList.add(Integer.parseInt(list.get(i)));
            } else {
                a = Integer.parseInt(str[0]);
                for (int j = 1; j < str.length; j++) {
                    b = Integer.parseInt(str[j]);
                    a += b;
                }
                iList.add(a);
            }
        }

        int answer = iList.get(0);
        for (int i = 1; i < iList.size(); i++) {
            answer -= iList.get(i);
        }

        System.out.println(answer);
    }
}
