import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681_해밀턴순환회로_김동곤 {
	private static int N;
	private static int[][] arr;
	private static boolean[] visited;
	private static int MIN;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_JO_1681_해밀턴순환회로.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		MIN = Integer.MAX_VALUE;
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		visited[0] = true;
		
		dfs(0, 0, 0);
		
		System.out.println(MIN);
	}
	
	public static void dfs(int cnt, int weight, int cur) {
		if (cnt == N - 1) {
			if (arr[cur][0] != 0) {				
				MIN = Math.min(MIN, weight + arr[cur][0]);
			}
			return;
		}
		if (weight >= MIN) {
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if (visited[i]) continue;
			if (arr[cur][i] != 0) {
				visited[i] = true;
				dfs(cnt + 1, weight + arr[cur][i], i);
				visited[i] = false;	
			}
		}
	}
}
