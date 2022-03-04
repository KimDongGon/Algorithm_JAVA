package Baekjoon.no1000.no1900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1987 {
	private static int R, C, answer, MAX;
	private static String[][] arr;
	private static int[][] dir = {
			{ -1, 0 },
			{ 1, 0 },
			{ 0, -1 },
			{ 0, 1 }
	};
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_1987_알파벳.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		String[] st = s.split(" ");
		
		R = Integer.parseInt(st[0]);
		C = Integer.parseInt(st[1]);
		
		arr = new String[R + 1][C + 1];
		
		visited = new boolean[26];
		
		answer = 0;
		
		MAX = Integer.MIN_VALUE;
		
		for (int i = 1; i <= R; i++) {
			s = reader.readLine();
			st = s.split("");
			for (int j = 1; j <= C; j++) {
				arr[i][j] = st[j - 1];
			}
		}
		
		visited[arr[1][1].charAt(0) - 'A'] = true;
		
		solve(1, 1, 1);
		
		System.out.println(MAX);
	}
	
	public static void solve(int row, int col, int cnt) {
		if (cnt > MAX) {
			MAX = cnt;
		}
		
		int r, c, idx;
		
		for (int[] d : dir) {
			r = row + d[0];
			c = col + d[1];
			if (1 <= r && r <= R && 1 <= c && c <= C) {
				idx = arr[r][c].charAt(0) - 'A';
				if (visited[idx]) continue;
				visited[idx] = true;
				solve(r, c, cnt + 1);
				visited[idx] = false;
			}
		}
	}
	
	public static void print(String[][] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
