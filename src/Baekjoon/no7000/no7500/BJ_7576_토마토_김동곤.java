package Baekjoon.no7000.no7500;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토_김동곤 {
	private static int M, N;
	private static int[][] arr;
	private static Queue<int[]> queue;
	private static int answer;
	private static int[][] dir = {
			{ -1, 0 },
			{ 1, 0 },
			{ 0, -1 },
			{ 0, 1 }
	};
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_7576_토마토.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		queue = new LinkedList<int[]>();
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (arr[i][j] == 1) {
					queue.add(new int[] { i, j });
				}
			}
		}
		
		bfs();
		
		if (!check()) {
			System.out.println(-1);
		} else {			
			System.out.println(answer - 1);
		}
	}
	
	public static void bfs() {
		
		int[] cur;
		int row, col, _row, _col;
		int len;
		
		while (!queue.isEmpty()) {
			
			len = queue.size();
			
			for (int i = 0; i < len; i++) {				
				cur = queue.poll();
				row = cur[0];
				col = cur[1];
				
				for (int[] d : dir) {
					_row = row + d[0];
					_col = col + d[1];
					if (isIn(_row, _col) && arr[_row][_col] == 0) {
						queue.add(new int[] {_row, _col});
						arr[_row][_col] = 1;
					}
				}
			}
			
			answer++;
		}
	}
	
	public static boolean isIn(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < M;
	}
	
	public static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
}
