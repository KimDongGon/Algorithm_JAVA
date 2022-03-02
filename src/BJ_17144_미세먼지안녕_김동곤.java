import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕_김동곤 {
	private static int R, C, T;
	private static int[][] arr;
	private static Queue<int[]> queue;
	private static int[] cleaner;
	private static int[][] dir = {
		{ -1, 0 },
		{ 1, 0 },
		{ 0, -1 },
		{ 0, 1 }
	};
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_17144_미세먼지안녕.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		queue = new LinkedList<int[]>();
		int idx = 1;
		
		for (int i = 0; i < R; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (arr[i][j] != 0 && arr[i][j] != -1) {
					queue.add(new int[] {i, j, 0});
				} else if (arr[i][j] == -1) {
					idx = i;
				}
			}
		}
		
		cleaner = new int[] {idx - 1, idx};
		int len;
		int[] pos;
		int row, col, _row, _col, cnt = 0, t = 0;
		
		while (!queue.isEmpty() && t++ < T) {
			
			len = queue.size();
			
			for (int i = 0; i < len; i++) {
				pos = queue.poll();
				row = pos[0];
				col = pos[1];
				cnt = 0;
				
				for(int[] d : dir) {
					_row = row + d[0];
					_col = col + d[1];
					
					if (isIn(_row, _col)) {
						if (!(_col == 0 && _row == cleaner[0]) && !(_col == 0 && _row == cleaner[1])) {
							queue.add(new int[] {_row, _col, arr[row][col] / 5});
							cnt ++;
						}
					}
				}
				
				if (cnt > 0) {
					queue.add(new int[] { row, col, - (cnt * (arr[row][col] / 5))});
				}
			}
			
			len = queue.size();
			
			for (int i = 0; i < len; i++) {
				pos = queue.poll();
				row = pos[0];
				col = pos[1];
				arr[row][col] += pos[2];
			}
			
			rotate();
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (arr[i][j] != 0 && arr[i][j] != -1) {
						queue.add(new int[] {i, j});
					}
				}
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != 0 && arr[i][j] != -1) {
					answer += arr[i][j];
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static boolean isIn(int row, int col) {
		return 0 <= row && row < R && 0 <= col && col < C;
	}
	
	public static void rotate() {
		// 공기 청정기 위 회전
		for (int i = cleaner[0] - 1; i > 0; i--) {
			arr[i][0] = arr[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			arr[0][i] = arr[0][i + 1];
		}
		for (int i = 0; i < cleaner[0]; i++) {
			arr[i][C - 1] = arr[i + 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			arr[cleaner[0]][i] = arr[cleaner[0]][i - 1];
		}
		arr[cleaner[0]][1] = 0;
		
		// 공기 청정기 아래 회전
		for (int i = cleaner[1] + 1; i < R - 1; i++) {
			arr[i][0] = arr[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			arr[R - 1][i] = arr[R - 1][i + 1];
		}
		for (int i = R - 1; i > cleaner[1]; i--) {
			arr[i][C - 1] = arr[i - 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			arr[cleaner[1]][i] = arr[cleaner[1]][i - 1];
		}
		arr[cleaner[1]][1] = 0;
	}
}

