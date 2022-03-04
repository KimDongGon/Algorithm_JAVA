package Baekjoon.no2000.no2600;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_2605_줄세우기_김동곤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		int num;
		
		for (int i = 1; i <= N; i++) {
			num = sc.nextInt();
			if (num == 0) {
				list.add(i);
			} else {
				list.add(i - num - 1, i);
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
