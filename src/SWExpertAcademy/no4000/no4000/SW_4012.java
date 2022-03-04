package SWExpertAcademy.no4000.no4000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_4012 {
	private static int MIN;
	private static int N;
	private static int[][] arr;
	private static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/input_SW_4012_요리사.txt"));
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.valueOf(reader.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.valueOf(reader.readLine());
			
			MIN = Integer.MAX_VALUE;
			
			arr = new int[N][N];
			
			visited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				s = reader.readLine();
				st = new StringTokenizer(s);
				
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.valueOf(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] += arr[j][i];
				}
			}
			
			solve(0, 0);
			
			sb.append("#").append(tc).append(" ").append(MIN).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void solve(int count, int start) {
		if (count == N / 2) {
			check();
			return;
		}
		
		for (int i = start; i < N; i++) {
			visited[i] = true;
			solve(count + 1, i + 1);
			visited[i] = false;
		}
		
	}
	
	public static void check() {
		int a_sum = 0;
		int b_sum = 0;
		
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();		
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				a.add(i);
			} else {
				b.add(i);
			}
		}
		
		for (int i = 0; i < a.size() - 1; i++) {
			for (int j = i + 1; j < a.size(); j++) {
				a_sum += arr[a.get(i)][a.get(j)];
				b_sum += arr[b.get(i)][b.get(j)];
			}
		}
		
		int x = Math.abs(a_sum - b_sum);
		MIN = Math.min(MIN, x);
	}
}
