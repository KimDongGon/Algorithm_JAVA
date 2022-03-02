import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17406_배열돌리기4_김동곤 {
	private static int[][] arr;
	private static int[][] op;
	private static int[] per_op;
	private static int n;
	private static int m;
	private static int k;
	private static boolean[] isVisited;
	private static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_17406_배열돌리기4.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringTokenizer st;
		
		s = reader.readLine();
		st = new StringTokenizer(s);
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		arr = new int[n][m];
		
		
		for (int i = 0; i < n; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		op = new int[k][3];
		per_op = new int[k];
		isVisited = new boolean[k];
		
		for (int i = 0; i < k; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < 3; j++) {
				op[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		permutation(0);
		
		System.out.println(MIN);
	}
	
	public static void permutation(int count) {
		if (count == k) {
			solve();
			return;
		}
		
		for (int i = 0; i < k; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				per_op[count] = i;
				permutation(count + 1);
				isVisited[i] = false;
			}
		}
	}
	
	public static void solve() {
		int[][] arr2 = new int[n][m];
		int[][] arr3 = new int[n][m];
		int r, c, s;
		int[][] temp;
		int row_min, row_max, col_min, col_max;
		Queue<int[]> q = new LinkedList<int[]>();
		int[] coord;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr2[i][j] = arr[i][j];
				arr3[i][j] = arr[i][j];
			}
		}
		
		for (int p : per_op) {
			r = op[p][0];
			c = op[p][1];
			s = op[p][2];
			
			temp = new int[2 * s + 1][2 * s + 1];
			row_min = r - s - 1;
			row_max = r + s - 1;				
			col_min = c - s - 1;
			col_max = c + s - 1;
			for (int t = 0; t <= s; t++) {
				// 오른 방향
				for (int i = col_min; i <= col_max; i++) {
					q.add(new int[] { row_min , i });
				}
				// 아래 방향
				for (int i = row_min + 1; i <= row_max; i++) {
					q.add(new int[] { i , col_max });
				}
				// 왼 방향
				for (int i = col_max - 1; i >= col_min; i--) {
					q.add(new int[] { row_max , i });
				}
				// 위 방향
				for (int i = row_max - 1; i > row_min; i--) {
					q.add(new int[] { i , col_min });
				}
				
				q.add(q.poll());
				
				// 오른 방향
				for (int i = col_min; i <= col_max; i++) {
					coord = q.poll();
					if (t % 2 == 0) {						
						arr2[coord[0]][coord[1]] = arr3[row_min][i];
					} else {
						arr3[coord[0]][coord[1]] = arr2[row_min][i];						
					}
				}
				// 아래 방향
				for (int i = row_min + 1; i <= row_max; i++) {
					coord = q.poll();
					if (t % 2 == 0) {	
						arr2[coord[0]][coord[1]] = arr3[i][col_max];
					} else {
						arr3[coord[0]][coord[1]] = arr2[i][col_max];						
					}
				}
				// 왼 방향
				for (int i = col_max - 1; i >= col_min; i--) {
					coord = q.poll();
					if (t % 2 == 0) {						
						arr2[coord[0]][coord[1]] = arr3[row_max][i];
					} else {
						arr3[coord[0]][coord[1]] = arr2[row_max][i];						
					}
				}
				// 위 방향
				for (int i = row_max - 1; i > row_min; i--) {
					coord = q.poll();
					if (t % 2 == 0) {
						arr2[coord[0]][coord[1]] = arr3[i][col_min];
					} else {
						arr3[coord[0]][coord[1]] = arr2[i][col_min];						
					}
				}
				
				// 오른 방향
				for (int i = col_min; i <= col_max; i++) {
					coord = q.poll();
					if (t % 2 == 0) {						
						arr3[row_min][i] = arr2[row_min][i];
					} else {
						arr2[row_min][i] = arr3[row_min][i];						
					}
				}
				// 아래 방향
				for (int i = row_min + 1; i <= row_max; i++) {
					coord = q.poll();
					if (t % 2 == 0) {	
						arr3[i][col_max] = arr2[i][col_max];
					} else {
						arr2[i][col_max] = arr3[i][col_max];						
					}
				}
				// 왼 방향
				for (int i = col_max - 1; i >= col_min; i--) {
					coord = q.poll();
					if (t % 2 == 0) {						
						arr3[row_max][i] = arr2[row_max][i];
					} else {
						arr2[row_max][i] = arr3[row_max][i];						
					}
				}
				// 위 방향
				for (int i = row_max - 1; i > row_min; i--) {
					coord = q.poll();
					if (t % 2 == 0) {
						arr3[i][col_min] = arr2[i][col_min];
					} else {
						arr2[i][col_min] = arr3[i][col_min];						
					}
				}
				row_min++;
				row_max--;
				col_min++;
				col_max--;
			}
		}
		
		min(arr2);
	}
	
	public static void min(int[][] arr) {
		int sum;
		for (int i = 0; i < arr.length; i++) {
			sum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			if (sum < MIN) {
				MIN = sum;
			}
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
