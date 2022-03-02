import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수_김동곤 {
	private static int[] parent;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_D4_7465_창용마을무리의개수.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String s = reader.readLine();
		StringTokenizer st;
		int T = Integer.parseInt(s);
		
		int N, M, a, b, answer;
		
		boolean[] root;
		
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			
			sb.append("#").append(tc).append(" ");
			
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			root = new boolean[N + 1];
			
			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				s = reader.readLine();
				st = new StringTokenizer(s);
				
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			for (int i = 1; i <= N; i++) {
				root[find(parent[i])] = true;
			}
			
			for (int i = 1; i <= N; i++) {
				if(root[i]) {
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int find(int a) {
		if (a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot != bRoot) {
			parent[aRoot] = bRoot;
		}
	}
}
