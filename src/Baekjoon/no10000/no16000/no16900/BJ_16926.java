package Baekjoon.no10000.no16000.no16900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16926 {
	public static void main(String[] args) throws IOException {
		long start = System.nanoTime();
		
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_16926_배열돌리기1.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringTokenizer st;
		int n, m, r, min;
		int row_max;
		int col_max;
		int len, rot;
		int[][] arr, arr2;
		Queue<int[]> q = new LinkedList<int[]>();
		int[] coord;
		
		s = reader.readLine();
		st = new StringTokenizer(s);
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		row_max = n - 1;
		col_max = m - 1;
		r = Integer.valueOf(st.nextToken());
		
		min = Math.min(n, m);
		
		arr = new int[n][m];
		arr2 = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		for (int t = 0; t < min / 2; t++) {
			// 아래 방향
			for (int i = t; i <= row_max; i++) {
				q.add(new int[] {i, t});
//				System.out.println("1: " + i +" " + t);
			}
			// 오른 방향
			for (int i = t + 1; i <= col_max; i++) {
				q.add(new int[] {row_max, i});
//				System.out.println("2: " + row_max +" " + i);
			}
			// 위 방향
			for (int i = row_max - 1; i >= t; i--) {
				q.add(new int[] {i, col_max});
//				System.out.println("3: " + i +" " + col_max);
			}
			// 왼 방향
			for (int i = col_max - 1; i > t; i--) {
				q.add(new int[] {t, i});
//				System.out.println("4: " + t +" " + i);
			}
			
			len = q.size();
			rot = r % len;
			for (int i = 0; i < rot; i++) {
				q.add(q.poll());
			}
			
			// 아래 방향
			for (int i = t; i <= row_max; i++) {
				coord = q.poll();
				arr2[coord[0]][coord[1]] = arr[i][t];
			}
			// 오른 방향
			for (int i = t + 1; i <= col_max; i++) {
				coord = q.poll();
				arr2[coord[0]][coord[1]] = arr[row_max][i];
			}
			// 위 방향
			for (int i = row_max - 1; i >= t; i--) {
				coord = q.poll();
				arr2[coord[0]][coord[1]] = arr[i][col_max];
			}
			// 왼 방향
			for (int i = col_max - 1; i > t; i--) {
				coord = q.poll();
				arr2[coord[0]][coord[1]] = arr[t][i];
			}
			
			row_max--;
			col_max--;
			q.clear();
		}
		
		
		print(arr2);
		
		
		long end = System.nanoTime();
//		System.out.println("수행 시간: " + (double)((end - start) / 1000000000.0) + "s");
	}
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
