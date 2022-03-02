import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10163_색종이_김동곤 {
	private static int N;
	private static int[][] arr;
	private static int[] area;
	private static int[][] dir = {
			{ -1, 0 },
			{ 1, 0 },
			{ 0, -1 },
			{ 0, 1 }
	};
	private static int maxR, maxC;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_10163_색종이.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String s;
		StringTokenizer st;
		String[] str;
		
		N = Integer.parseInt(reader.readLine());
		
		area = new int[N];
		str = new String[N];
		
		maxR = Integer.MIN_VALUE;
		maxC = Integer.MIN_VALUE;
		
		int r, c, w, h;
		
		for (int t = 0; t < N; t++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			str[t] = s;
			
			maxR = Math.max(maxR, r + w);
			maxC = Math.max(maxC, c + h);
		
		}
		
		arr = new int[maxR][maxC];
		
		for (int t = 1; t <= N; t++) {
			s = str[t - 1];
			st = new StringTokenizer(s);
			
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for (int i = r; i < r + w; i++) {
				for (int j = c; j < c + h; j++) {
					arr[i][j] = t;
				}
			}
		}
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			System.out.println(area[i]);
		}
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0, 0});
		int[] cur;
		int row, col, _row, _col;
		
		while (!queue.isEmpty()) {
			cur = queue.poll();
			row = cur[0];
			col = cur[1];
			
			for (int[] d : dir) {
				_row = row + d[0];
				_col = col + d[1];
				
				if (isIn(_row, _col) && arr[_row][_col] != 101) {
					if (arr[_row][_col] != 0) {						
						area[arr[_row][_col] - 1]++;
					}
					arr[_row][_col] = 101;
					queue.add(new int[] {_row, _col});
				}
			}
		}
	}
	
	public static boolean isIn(int row, int col) {
		return 0 <= row && row < maxR && 0 <= col && col < maxC;
	}
}
