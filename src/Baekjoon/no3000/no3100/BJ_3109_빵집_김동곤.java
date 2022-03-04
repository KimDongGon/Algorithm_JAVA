package Baekjoon.no3000.no3100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109_빵집_김동곤 {
	private static int R, C, answer;
	private static String[][] arr;
	private static int[][] dir = {
			{-1, 1},
			{0, 1},
			{1, 1}
	};
	private static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_3109_빵집.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		String[] st = s.split(" ");
		
		answer = 0;
		
		R = Integer.parseInt(st[0]);
		C = Integer.parseInt(st[1]);
		
		arr = new String[R][C];
		
		for (int i = 0; i < R; i++) {
			s = reader.readLine();
			st = s.split("");
			for (int j = 0; j < C; j++) {
				arr[i][j] = st[j];
			}
		}
		
		for (int i = 0; i < R; i++) {
			flag = false;
			solve(i, 0, 0);
		}
		
		System.out.println(answer);
	}
	
	public static void solve(int row, int col, int cnt) {
		if (cnt == C - 1) {
			flag = true;
			answer++;
			return;
		}
		
		int r, c;
		if (col == 0) {
			arr[row][col] = "o";
		}
		for (int[] d : dir) {
			r = row + d[0];
			c = col + d[1];
			
			if (0 <= r && r < R && 0 <= c && c < C && arr[r][c].equals(".")) {
				if (!flag) {					
					arr[r][c] = "o";
					solve(r, c, cnt + 1);
				}
			}
		}
	}
	
	public static void print(String[][] arr) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
