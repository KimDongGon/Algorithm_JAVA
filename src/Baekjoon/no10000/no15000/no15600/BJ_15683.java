package Baekjoon.no10000.no15000.no15600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_15683 {
	private static char[][] arr;
	private static int N, M, MIN;
	private static int[][] dir = {
			{ 0, 1 }, // 우
			{ 0, -1 }, // 좌
			{ -1, 0 }, // 상
			{ 1, 0 } // 하
	};
	private static int[][][] cctvDir = {
			{ },
			{ {0}, {1}, {2}, {3} },
			{ {0, 1}, {2, 3} },
			{ {0, 2}, {1, 2}, {0, 3}, {1, 3} },
			{ {0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3} },
			{ {0, 1, 2, 3} }
	};
	private static List<int[]> pos;
	private static int len;
	private static Stack<int[]> stack;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_15683_감시.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		MIN = 0;
		
		arr = new char[N][M];
		
		pos = new ArrayList<int[]>();
		
		stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = st.nextToken().charAt(0);
				if (arr[i][j] == '0') {
					MIN++;
				} else if ('1' <= arr[i][j] && arr[i][j] <= '5') {
					pos.add(new int[]{i, j});
				}
			}
		}
		
		len = pos.size();
		
		solve(0);
		
		System.out.println(MIN);
	}
	
	public static void solve(int cnt) {
		if (cnt == len) {
			check();
			return;
		}
		
		int r = pos.get(cnt)[0];
		int c = pos.get(cnt)[1];
		
		int cctv = arr[r][c] - '0';
		for (int i = 0; i < cctvDir[cctv].length; i++) {
			change(cctvDir[cctv][i], r, c, true);
			solve(cnt + 1);
			change(cctvDir[cctv][i], r, c, false);
		}
	}
	
	public static void change(int[] cctvDir, int r, int c, boolean flag) {

		int _r, _c;
		for (int i = 0; i < cctvDir.length; i++) {
			_r = r;
			_c = c;
			while (true) {
				_r = _r + dir[cctvDir[i]][0];
				_c = _c + dir[cctvDir[i]][1];
				
				if (0 <= _r && _r < N && 0 <= _c && _c < M) {
					// 벽에 막힌 경우
					if (arr[_r][_c] == '6') break;
					
					// 벽에 막히지 않은 경우
					else {
						if ('1' <= arr[_r][_c] && arr[_r][_c] <= '5') continue;
						else if (flag) stack.add(new int[] {_r, _c});
						else stack.pop();
					}
				} else {
					break;
				}
				
			}
		}
	}
	
	public static void check() {
		int cnt = 0;
		
		char[][] temp = new char[N][M];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		
		int[] coordi;
		for (int i = 0; i < stack.size(); i++) {
			coordi = stack.get(i);
			temp[coordi[0]][coordi[1]] = '#';
		}
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if (temp[i][j] == '0') {
					cnt++;
				}
			}
		}
		
		MIN = Math.min(MIN, cnt);
	}
	
	public static void print(char[][] arr) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
