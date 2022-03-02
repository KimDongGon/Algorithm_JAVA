import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10026_적록색약_김동곤 {
	private static char[][] arr;
	private static boolean[][] visited;
	private static int N, answer;
	private static int[][] dir = {
			{ -1, 0 },
			{ 1, 0 },
			{ 0, 1 },
			{ 0, -1 }
	};
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_10026_적록색약.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		char[] st;
		
		N = Integer.parseInt(s);
		
		arr = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = s.toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = st[j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					answer ++;
					dfs(i, j, arr[i][j]);
				}
			}
		}
		
		System.out.print(answer + " ");
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'R') {
					arr[i][j] = 'G';
				}
			}
		}
		
		answer = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					answer ++;
					dfs(i, j, arr[i][j]);
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void dfs(int row, int col, char color) {
		int _row, _col;
		
		for (int[] d : dir) {
			_row = row + d[0];
			_col = col + d[1];
			
			if (isIn(_row, _col) && !visited[_row][_col] && arr[_row][_col] == color) {
				visited[_row][_col] = true;
				dfs(_row, _col, color);
			}
		}
	}
	
	public static boolean isIn(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < N;
	}
}
