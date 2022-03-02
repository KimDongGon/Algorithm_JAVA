import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2_1954_달팽이숫자 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D2_1954_달팽이숫자.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N;
		int[][] arr;
		int[][] d = {
				{ 0, 1 },
				{ 1, 0 },
				{ 0, -1 },
				{ -1, 0 },
		};
		int idx;
		int row, col;
		int _row, _col;
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			
			idx = 0;
			row = 0;
			col = 0;
			_row = 0;
			_col = 0;
			
			for (int i = 1; i <= N * N; i++) {
				arr[row][col] = i;
				
				_row = row + d[idx][0];
				_col = col + d[idx][1];
				
				if (0 <= _row && _row <= N - 1 && 0 <= _col && _col <= N - 1 && arr[_row][_col] == 0) {

				} else {
					if (idx == 3) {
						idx = 0;
					} else {
						idx++;
					}
				}
				
				row += d[idx][0];
				col += d[idx][1];
			}
			System.out.println("#" + tc);
			print(arr);
		}
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
