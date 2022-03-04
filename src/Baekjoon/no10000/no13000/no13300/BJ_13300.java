package Baekjoon.no10000.no13000.no13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300 {
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_13300_방배정.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int answer = 6 * 2;
		
		int[][] arr = new int[6][2];
		
		int gender, grade;
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			gender = Integer.parseInt(st.nextToken());
			grade = Integer.parseInt(st.nextToken());
			
			arr[grade - 1][gender] ++;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					answer--;
				} else if (arr[i][j] > K) {
					if (arr[i][j] % K == 0)
						answer += arr[i][j] / K - 1;
					else
						answer += arr[i][j] / K;
				}
			}
		}
		
		System.out.println(answer);
	}
}
