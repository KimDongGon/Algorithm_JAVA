package Baekjoon.no10000.no11000.no11600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
