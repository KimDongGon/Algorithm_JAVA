package Baekjoon.no2000.no2300;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2304_창고다각형_김동곤 {
	private static class Square implements Comparable<Square> {
		int x;
		int y;
		
		public Square(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Square o) {
			return this.x - o.x;
		}

		@Override
		public String toString() {
			return "Square [x=" + x + ", y=" + y + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_2304_창고다각형.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		String s = reader.readLine(); 
		StringTokenizer st;
		
		int N = Integer.parseInt(s);
		
		Square[] sqs = new Square[N];
		
		int x, y;
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			sqs[i] = new Square(x, y);
		}
		
		int answer = 0;
		int idx = 0;
		
		Arrays.sort(sqs);
		
		x = sqs[0].x;
		y = sqs[0].y;
		
		Square sq;
		
		if (N == 1) {
			answer += y;
		} else {
			for (int i = 1; i < N; i++) {
				sq = sqs[i];
				
				if (y <= sq.y) {
					answer += (sq.x - x) * (y);
					idx = i;
					x = sq.x;
					y = sq.y;
				}
				
				if (i == N - 1) {
					// 맨 끝의 기둥보다 이전 기둥이 큰 경우
					if (y > sq.y) {
						x = sqs[N - 1].x;
						y = sqs[N - 1].y;
						
						for (int j = N - 2; j >= idx; j--) {
							sq = sqs[j];
							
							if (y <= sq.y) {
								answer += (x - sq.x) * (y);
								x = sq.x;
								y = sq.y;
							}
							
						}
						
						answer += sqs[idx].y;
					} else {
						answer += y ;					
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
