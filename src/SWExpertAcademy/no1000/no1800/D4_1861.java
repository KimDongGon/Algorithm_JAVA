package SWExpertAcademy.no1000.no1800;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class D4_1861 {
	private static int n;
	private static int[][] arr;
	private static int min_start;
	private static int max_count;
	private static int[][] dir = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/input_D4_1861_정사각형방.txt"));
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(reader.readLine());
		StringTokenizer st;
		Stack<int[]> stack = new Stack<>();
		
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.valueOf(reader.readLine());
			arr = new int[n][n];
			min_start = Integer.MAX_VALUE;
			max_count = 0;
			
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(reader.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.valueOf(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					stack.clear();
					stack.add(new int[] {i, j});
					dfs(stack, 0, arr[i][j]);
				}
			}
			
			
			System.out.println("#" + tc + " " + min_start + " " + max_count);
		}
	}
	
	public static void dfs(Stack<int[]> stack, int count, int start) {
		if (stack.isEmpty()) {
			if (count > max_count) {
				min_start = start;
				max_count = count;
			} else if (count == max_count && start < min_start) {
				min_start = start;
			}
			return;
		}
		
		int[] cur = stack.pop();
		int row, col;
		
		for (int[] d : dir) {
			row = cur[0] + d[0];
			col = cur[1] + d[1];
			if (0 <= row && row < n && 0 <= col && col < n && arr[row][col] == arr[cur[0]][cur[1]] + 1) {
				stack.add(new int[] {cur[0] + d[0], cur[1] + d[1]});
			}
		}
		dfs(stack, count + 1, start);
	}
}
