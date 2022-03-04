package Baekjoon.no2000.no2500;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이_김동곤 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_2563_색종이.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		StringTokenizer st;
		
		int N = Integer.parseInt(reader.readLine());
		
		int[][] arr = new int[101][101];
		
		int row, col;
		
		for (int t = 0; t < N; t++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			
			for (int i = row; i < row + 10; i++) {
				for (int j = col; j < col + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					answer ++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
