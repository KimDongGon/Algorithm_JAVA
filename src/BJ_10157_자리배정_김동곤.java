import java.util.Scanner;

public class BJ_10157_자리배정_김동곤 {
	private static int N, M;
	private static int[][] dir = {
			{ 0, 1 },
			{ 1, 0 },
			{ 0, -1 },
			{ -1, 0 }
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		
		int arr[][] = new int[N][M];
		
		int idx = 0;
		int row, col, _row, _col;
		row = col = 0;
		int cnt = 0;
		
		arr[0][0] = 1;
		
		while(cnt < N * M) {
			
			if (cnt + 1 == K) {
				System.out.println((row + 1) + " " + (col + 1));
				break;
			}
			
			_row = row + dir[idx][0];
			_col = col + dir[idx][1];
			
			if (!isIn(_row, _col) || arr[_row][_col] != 0) {
				idx++;
				if (idx > 3) {
					idx = 0;
				}
			}
			
			row += dir[idx][0];
			col += dir[idx][1];
			
			arr[row][col] = cnt + 1;
			
			cnt++;
		}
		
		if (cnt + 1 < K) {
			System.out.println(0);
		}
	}
	
	public static boolean isIn(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < M;
	}
}
