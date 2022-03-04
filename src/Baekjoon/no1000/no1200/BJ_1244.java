package Baekjoon.no1000.no1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244 {
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_1244_스위치켜고끄기.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String s = reader.readLine();
		StringTokenizer st;
		
		int N = Integer.parseInt(s);
		int[] arr = new int[N + 1];
		
		s = reader.readLine();
		st = new StringTokenizer(s);
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(reader.readLine());
		
		int gender, idx, left, right;
		
		for (int i = 0; i < M; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			gender = Integer.parseInt(st.nextToken());
			idx = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				for (int j = idx; j <= N; j += idx) {
					arr[j] = arr[j] == 0 ? 1 : 0;
				}
			} else if (gender == 2) {
				left = idx - 1;
				right = idx + 1;
				
				while (left > 0 && right <= N && arr[left] == arr[right]) {
					left--;
					right++;
				}
				
				for (int j = left + 1; j < right; j++) {
					arr[j] = arr[j] == 0 ? 1 : 0;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		
		sb.setLength(sb.length() - 1);
		
		System.out.println(sb);
	}
}
