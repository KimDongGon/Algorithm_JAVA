package SWExpertAcademy.no3000.no3200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3289 {
	private static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_D4_3289_서로소집합.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		StringTokenizer st;
		
		int T = Integer.parseInt(reader.readLine());
		int n, m, op, a, b;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parent = new int[n + 1];
			
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				s = reader.readLine();
				st = new StringTokenizer(s);
				
				op = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				if (op == 0) {
					union(a, b);
				} else if (op == 1) {
					sb.append(findRoot(a, b));
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int find(int a) {
		if (a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	public static int findRoot(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return 1;
		return 0;
	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot != bRoot) {			
			parent[aRoot] = bRoot;
		}
	}
}
