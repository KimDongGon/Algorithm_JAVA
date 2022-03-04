package Baekjoon.no1000.no1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260 {
	private static int N, M, V;
	private static int[][] matrix;
	private static boolean[] visited;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_1260_DFS와BFS.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		int from, to;
		
		matrix = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			

			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}
		
		dfs(0, V);
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		
		sb = new StringBuilder();
		visited = new boolean[N + 1];
		
		bfs(V);
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	public static void dfs(int cnt, int current) {		
		visited[current] = true;
		sb.append(current).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && matrix[current][i] > 0) {
				dfs(cnt + 1, i);
			}
		}
	}
	
	public static void bfs(int current) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[current] = true;
		sb.append(current).append(" ");
		queue.add(current);
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && matrix[current][i] > 0) {
					queue.add(i);
					sb.append(i).append(" ");
					visited[i] = true;
				}
			}
		}
	}
}
