package Baekjoon.no2000.no2600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BJ_2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		
		List<Integer> answer = new LinkedList<>();
		String[] num = reader.readLine().split(" ");
		
		for (int i = 0; i < num.length; i++) {
			if (num[i] != "0") {
				answer.add(i - Integer.valueOf(num[i]), i + 1);
			} else {
				answer.add(i + 1);
			}
		}
		
		print(answer);
	}
	
	public static void print(List<Integer> answer) {
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}
}
