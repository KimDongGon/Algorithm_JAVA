import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573_빙산 {
	private static int N, M;
	private static int[][] arr;
	private static Queue<Ice> queue;
	private static boolean[][] visited;
	private static class Ice {
		int r;
		int c;
		int val;
		public Ice(int r, int c, int val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}
		@Override
		public String toString() {
			return "Ice [r=" + r + ", c=" + c + ", val=" + val + "]";
		}
	}
	private static int[][] dir = {
			{ -1, 0 },
			{ 1, 0 },
			{ 0, -1 },
			{ 0, 1 }
	};
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_2573_빙산.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		queue = new LinkedList<Ice>();
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0) {
					queue.add(new Ice(i, j, arr[i][j]));
				}
			}
		}
		
		solve(0);
	}
	
	public static void solve(int answer) {
		int len;
		Ice ice;
		int row, col, _row, _col, cnt, val;
		Queue<Ice> q = new LinkedList<>();
		
		while (!queue.isEmpty()) {
			len = queue.size();
			
			for (int i = 0; i < len; i++) {
				ice = queue.poll();
				row = ice.r;
				col = ice.c;
				cnt = 0;
				
				for (int[] d : dir) {
					_row = row + d[0];
					_col = col + d[1];
					if (isIn(_row, _col) && arr[_row][_col] == 0) {
						cnt++;
					}
				}
				
				if (arr[row][col] > cnt) {
					queue.add(new Ice(row, col, arr[row][col] - cnt));
				} else {
					queue.add(new Ice(row, col, 0));
				}
			}
			
			for (int i = 0; i < len; i++) {
				ice = queue.poll();
				row = ice.r;
				col = ice.c;
				val = ice.val;
				
				if (val != 0) {
					arr[row][col] = val;
					queue.add(ice);
				} else {
					arr[row][col] = 0;
				}
			}			
			
			if (queue.peek() == null) {
				System.out.println(0);
				break;
			}
			
			// bfs
			len = queue.size() - 1;
			q.add(queue.peek());
			visited = new boolean[N][M];
			visited[q.peek().r][q.peek().c] = true;
			
			while (!q.isEmpty()) {
				ice = q.poll();
				row = ice.r;
				col = ice.c;
				for (int[] d : dir) {
					_row = row + d[0];
					_col = col + d[1];
					if (isIn(_row, _col) && !visited[_row][_col] && arr[_row][_col] != 0) {
						visited[_row][_col] = true;
						q.add(new Ice(_row, _col, 0));
						len--;
					}
				}
			}
			
			if (len == 0) {
				answer++;
			} else {
				System.out.println(answer + 1);
				break;
			}
		}
	}
	
	public static boolean isIn(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < M;
	}
}
