package Baekjoon.no2000.no2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달_김동곤 {
	private static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(reader.readLine());
		int count = 0;

		if (N % 5 == 0) {
			MIN = Math.min(MIN, N / 5);
		}
		
		if (N % 3 == 0) {
			MIN = Math.min(MIN, N / 3);
		}
		
		while (true) {
			N -= 3;
			count ++;
			
			if (N < 0) {
				break;
			} else if (N == 0) {
				MIN = Math.min(MIN, count);
				break;
			} else if (N % 5 == 0) {
				MIN = Math.min(MIN, count + (N / 5));
				break;
			} else if (count > 5) {
				break;
			}
		}
		
		if (MIN == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(MIN);
		}
	}
	
}
