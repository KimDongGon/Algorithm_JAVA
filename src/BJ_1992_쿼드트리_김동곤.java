import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1992_쿼드트리_김동곤 {
	private static StringBuilder sb = new StringBuilder();
	private static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_1992_쿼드트리.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		String[] st;
				
		int N = Integer.parseInt(reader.readLine());
		arr = new int[N + 1][N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			s = reader.readLine();
			st = s.split("");
			
			for (int j = 0; j < N; j++) {
				arr[i][j + 1] = Integer.parseInt(st[j]);
			}
		}
		
		solve(N, 1, 1);
		
		System.out.println(sb);
	}
	
	public static void solve(int n, int row, int col) {
		if (n == 1) {
			for (int i = row; i < row + n; i++) {
				for (int j = col; j < col + n; j++) {
					sb.append(arr[i][j]);
				}
			}
			return;
		}
		int count = 0;
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if (arr[i][j] == 0) {
					count++;
				}
			}
		}
		
		if (count == n * n) {
			sb.append("0");
		} else if (count == 0) {
			sb.append("1");
		} else {
			sb.append("(");
			solve(n / 2, row, col);
			solve(n / 2, row, col + n / 2);
			solve(n / 2, row + n / 2, col);
			solve(n / 2, row + n / 2, col + n / 2);
			sb.append(")");	
		}
	}
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
