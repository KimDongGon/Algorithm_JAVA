import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16935_배열돌리기3_김동곤 {
	private static int[][] arr;
	private static int n;
	private static int m;	
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_16935_배열돌리기3.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int r, _r;
		
		String s;
		StringTokenizer st;
		
		s = reader.readLine();
		st = new StringTokenizer(s);
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		r = Integer.valueOf(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		s = reader.readLine();
		st = new StringTokenizer(s);

		for (int i = 0; i < r; i++) {
			_r = Integer.valueOf(st.nextToken());
			switch(_r) {
			case 1:
				swap1(true);
				break;
			case 2:
				swap1(false);
				break;
			case 3:			
				swap2(true);
				break;
			case 4:			
				swap2(false);
				break;
			case 5:
				swap3(true);
				break;
			case 6:
				swap3(false);
				break;
			}
		}
		
		print(arr);
	}
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void swap1(boolean check) {
		int[][] arr2 = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check) {					
					arr2[n - i - 1][j] = arr[i][j];
				} else {
					arr2[i][m - j - 1] = arr[i][j];
				}
			}
		}
		
		arr = arr2;
	}
	
	public static void swap2(boolean check) {
		rotate(check);
		swap1(false);
	}
	
	public static void rotate(boolean check) {
		int[][] arr2 = new int[m][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check) {					
					arr2[j][i] = arr[i][j];
				} else {
					arr2[m - j - 1][n - i - 1] = arr[i][j];
				}
			}
		}
		
		int temp = n;
		n = m;
		m = temp;
		
		arr = arr2;
	}
	
	public static void swap3(boolean check) {
		int[] dir;
		if(check) {
			dir = new int[] { 1, 3, 0, 2 };
		} else {
			dir = new int[] { 2, 0, 3, 1 };			
		}
		
		int[][] idx = new int[][] {
			{0, 0, n / 2, m / 2},
			{0, m / 2, n / 2, m },
			{n / 2, 0, n, m / 2},
			{n / 2, m / 2, n, m}
		};
		int[][][] temp = new int[4][n / 2][m / 2];
		int[][][] temp2 = new int[4][n / 2][m / 2];
		int temp_idx = 0;
		int temp_i;
		int temp_j;
		
		for (int[] _idx : idx) {
			temp_i = 0;
			for (int i = _idx[0]; i < _idx[2]; i++) {
				temp_j = 0;
				for (int j = _idx[1]; j < _idx[3]; j++) {
					temp[temp_idx][temp_i][temp_j] = arr[i][j];
					temp_j++;
				}
				temp_i++;
			}
			temp_idx ++;
		}
		
		for (int j = 0; j < 4; j++) {
			temp2[dir[j]] = temp[j];
		}
		temp = temp2;
		
		temp_idx = 0;
		
		for (int[] _idx : idx) {
			temp_i = 0;
			for (int i = _idx[0]; i < _idx[2]; i++) {
				temp_j = 0;
				for (int j = _idx[1]; j < _idx[3]; j++) {
					arr[i][j] = temp2[temp_idx][temp_i][temp_j];
					temp_j++;
				}
				temp_i++;
			}
			temp_idx ++;
		}
	}
}
