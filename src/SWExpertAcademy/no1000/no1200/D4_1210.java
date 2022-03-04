package SWExpertAcademy.no1000.no1200;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D4_1210 {
	private static int[][] arr;
	private static int LEN = 100;
	private static int idx;
	private static int[][] dir = {
			{0, -1},
			{0, 1},
			{1, 0}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/input_D4_1210_Ladder1.txt"));
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		StringTokenizer st;
		ArrayList<Integer> list;
		int val;
		
		for (int tc = 1; tc <= 10; tc++) {
			s = reader.readLine();
			arr = new int[LEN][LEN];
			list = new ArrayList<>();
			idx = -1;
			
			for (int i = 0; i < LEN; i++) {
				s = reader.readLine();
				st = new StringTokenizer(s);
				for (int j = 0; j < LEN; j++) {
					arr[i][j] = Integer.valueOf(st.nextToken());
					if (i == 0 && arr[i][j] == 1) {
						list.add(j);
					}
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				val = list.get(i);
				solve(val, 0, val, 2);
				if (idx != -1) {
					break;
				}
			}
			
			System.out.println("#" + tc + " " + idx);
		}
	}
	
	// prev: 0(왼쪽), 1(오른쪽), 2(아래)
	public static void solve(int start, int row, int col, int prev) {
		if (row + 1 == LEN) {
			if (arr[row][col] == 2) {
				idx = start;
			}
			return;
		}
		
		int _row;
		int _col;
		for (int i = 0; i < dir.length; i++) {
			_row = row + dir[i][0];
			_col = col + dir[i][1];
			if (0 <= _row && _row < LEN && 0 <= _col && _col < LEN) {
				if (arr[_row][_col] == 1 || arr[_row][_col] == 2) {
					arr[row][col] = 0;
					solve(start, _row, _col, i);
					arr[row][col] = 1;
					break;
				}
			}
		}
		
	}
}
