package Baekjoon.no2000.no2500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int MAX = Integer.MIN_VALUE;
		
		int[] arr = new int[N];
		
		s = reader.readLine();
		st = new StringTokenizer(s);
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for (int i = 0; i < K; i++) {
			answer += arr[i];
		}
		
		MAX = Math.max(MAX, answer);
		
		for (int i = K; i < N; i++) {
			answer += arr[i];
			answer -= arr[i - K];
			
			MAX = Math.max(MAX, answer);
		}
		
		System.out.println(MAX);
	}
}
