package SWExpertAcademy.no1000.no1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1247 {
	private static int N;
	private static int[] house;
	private static int[] company;
	private static int[][] customer;
	private static int sum, MIN;
	private static int[] arr;
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_D5_1247_최적경로.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String s = reader.readLine();
		StringTokenizer st;
		
		int T = Integer.parseInt(s);
		int x, y;
		int idx1, idx2;
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(reader.readLine());
			
			arr = new int[N];
			customer = new int[N][2];
			MIN = Integer.MAX_VALUE;
			sum = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = i;
			}
			
			s = reader.readLine();
			st = new StringTokenizer(s);
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			house = new int[] {x, y};
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			company = new int[] {x, y};
			
			for (int i = 0; i < N; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				customer[i][0] = x;
				customer[i][1] = y;
			}
			
			do {
				sum = Math.abs(company[0] - customer[arr[0]][0]) + Math.abs(company[1] - customer[arr[0]][1]);
				for (int i = 0; i < N - 1; i++) {
					idx1 = arr[i];
					idx2 = arr[i + 1];
					sum += Math.abs(customer[idx1][0] - customer[idx2][0]) + Math.abs(customer[idx1][1] - customer[idx2][1]);
				}
				sum += Math.abs(house[0] - customer[arr[N - 1]][0]) + Math.abs(house[1] - customer[arr[N - 1]][1]);
				MIN = Math.min(MIN, sum);
			} while(np());
			
			sb.append("#").append(tc).append(" ").append(MIN).append("\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	public static boolean np() {
		int i = N - 1;
		
		while (i > 0 && arr[i - 1] >= arr[i]) --i;
		
		if (i == 0) {
			return false;
		}
		
		int j = N - 1;
		
		while (arr[i - 1] >= arr[j]) --j;
		
		swap(i - 1, j);
		
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void print(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		
		System.out.println(sb);
	}
}
