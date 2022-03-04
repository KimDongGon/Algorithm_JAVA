package Baekjoon.no2000.no2500;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2578_빙고_김동곤 {
	private static boolean[][] arr;
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_2578_빙고.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		StringTokenizer st;
		
		int[][] me = new int[5][5];
		int[][] mond = new int[5][5];
		arr = new boolean[5][5];
		
		for (int i = 0; i < 5; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < 5; j++) {
				me[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < 5; j++) {
				mond[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		upper:
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				answer++;
				
				upper2:
				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						if (me[r][c] == mond[i][j]) {
							arr[r][c] = true;
							break upper2;
						}
					}
				}
				if (check()) {
					break upper;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static boolean check() {
		int cnt = 0;
		boolean bingo;
		for (int i = 0; i < 5; i++) {
			// 가로
			bingo = true;
			for (int j = 0; j < 5; j++) {
				if (!arr[i][j]) {
					bingo = false;
					break;
				}
			}
			
			if(bingo) {
				cnt++;
			}
			
			// 세로
			bingo = true;
			for (int j = 0; j < 5; j++) {
				if (!arr[j][i]) {
					bingo = false;
					break;
				}
			}
			
			if(bingo) {
				cnt++;
			}
		}
		
		bingo = true;
		for (int i = 0; i < 5; i++) {
			if (!arr[i][i]) {
				bingo = false;
				break;
			}
			
		}
		if(bingo) {
			cnt++;
		}
		
		bingo = true;
		for (int i = 0; i < 5; i++) {
			if (!arr[4 - i][i]) {
				bingo = false;
				break;
			}
			
		}
		if(bingo) {
			cnt++;
		}
		
		if (cnt >= 3) {
			return true;
		}
		return false;
	}
}
