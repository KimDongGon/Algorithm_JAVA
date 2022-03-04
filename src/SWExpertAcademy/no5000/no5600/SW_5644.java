package SWExpertAcademy.no5000.no5600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5644 {
	// 전체 맵
	private static int[][] map;
	// 무선 충전기의 충전량
	private static int[] BC;
	
	// A: a의 이동 순서, B: b의 이동 순서
	private static int[] A, B;
	
	// m: 이동 시간, n: bc의 개수
	private static int m, n;
	
	private static int answer;
	
	private static int[][] d = {
			{ 0, 0 },
			{ -1, 0 },
			{ 0, 1 },
			{ 1, 0 },
			{ 0, -1 }			
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_모의SW역량테스트_무선충전.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		StringTokenizer st;
		
		int x, y, c, p;
		
		int T = Integer.valueOf(reader.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			
			map = new int[10 + 1][10 + 1];
			
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			m = Integer.valueOf(st.nextToken());
			n = Integer.valueOf(st.nextToken());			
			
			A = new int[m + 2];
			B = new int[m + 2];
			
			BC = new int[n + 1];
			
			// A 초기화
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			for (int i = 1; i <= m; i++) {
				A[i] = Integer.valueOf(st.nextToken());
			}
			
			// B 초기화
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			for (int i = 1; i <= m; i++) {
				B[i] = Integer.valueOf(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				s = reader.readLine();
				st = new StringTokenizer(s);
				
				x = Integer.valueOf(st.nextToken());
				y = Integer.valueOf(st.nextToken());
				c = Integer.valueOf(st.nextToken());
				p = Integer.valueOf(st.nextToken());
				
				BC[i] = p;
				initBC(i, x, y, c);
				
			}
			
			find(0, 1, 1, 10, 10);
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	public static void initBC(int no, int x, int y, int c) {
		for (int i = x - c; i <= x + c; i++) {
			for (int j = y - c; j <= y + c; j++) {
				if (1 <= i && i <= 10 && 1 <= j && j <= 10 && Math.abs(i - x) + Math.abs(j - y) <= c) {
					if (map[j][i] == 0) {
						map[j][i] = no;
					} else if (map[j][i] / 10 != 0) {
						int c1 = BC[map[j][i] / 10];
						int c2 = BC[map[j][i] % 10];
						int c3 = BC[no];
						
						if ((c1 >= c2 && c2 >= c3) || (c2 >= c1 && c1 >= c3)) { // c1 && c2
							continue;
						} else if ((c2 >= c3 && c3 >= c1) || (c3 >= c2 && c2 >= c1)) { // c2 && c3
							map[j][i] = (map[j][i] % 10) * 10 + no;
						} else if ((c1 >= c3 && c3 >= c2) || (c3 >= c1 && c1 >= c2)) { // c1 && c3
							map[j][i] = (map[j][i] / 10) * 10 + no;
						}
						
					} else {
						map[j][i] = map[j][i] * 10 + no;
					}
				}
			}
		}
	}
	
	public static void find(int count, int rowA, int colA, int rowB, int colB) {
		if (count == m + 1) {
			return;
		}
		
		int cA = map[rowA][colA];
		int cB = map[rowB][colB];
		
		int cA1, cA2, cB1, cB2;
		
		
		// A가 0, B는 0이 아닌 경우
		// B가 한 자리 수 인경우
		// B가 두 자리 수 인경우		
		if (cA == 0 && cB != 0) {
			if (cB / 10 == 0) {
				answer += BC[cB];
			} else {
				cB1 = cB / 10;
				cB2 = cB % 10;
				
				answer += Math.max(BC[cB1], BC[cB2]);
			}
		}
		
		// A가 0이 아니고, B는 0인 경우
		// A가 한 자리 수 인경우
		// B가 두 자리 수 인경우
		else if (cA != 0 && cB == 0) {
			if (cA / 10 == 0) {
				answer += BC[cA];
			} else {
				cA1 = cA / 10;
				cA2 = cA % 10;
				
				answer += Math.max(BC[cA1], BC[cA2]);
			}
		}
		
		// A, B 둘 다 0이 아닌 경우
		// A, B가 한 자리수
		// A는 한 자리수, B는 두 자리수
		// B는 한 자리수, A는 두 자리수
		// A, B가 두 자리수
		else if (cA != 0 && cB != 0) {
			if (cA / 10 == 0 && cB / 10 == 0) {
				if (cA == cB) {
					answer += BC[cA];
				} else {
					answer += BC[cA] + BC[cB];
				}
			} else if (cA / 10 == 0 && cB / 10 != 0) {
				cB1 = cB / 10;
				cB2 = cB % 10;
				
				if (cA == cB1) {					
					answer += BC[cA] + BC[cB2];
				} else if (cA == cB2) {
					answer += BC[cA] + BC[cB1];
				} else {
					answer += BC[cA] + Math.max(BC[cB1], BC[cB2]);
				}
			} else if (cA / 10 != 0 && cB / 10 == 0) {
				cA1 = cA / 10;
				cA2 = cA % 10;
				
				if (cB == cA1) {					
					answer += BC[cB] + BC[cA2];
				} else if (cB == cA2) {
					answer += BC[cB] + BC[cA1];
				} else {
					answer += BC[cB] + Math.max(BC[cA1], BC[cA2]);
				}
			} else {
				cA1 = cA / 10;
				cA2 = cA % 10;
				
				cB1 = cB / 10;
				cB2 = cB % 10;
				
				if (cA == cB || (cA1 == cB2 && cA2 == cB1)) {
					answer += BC[cA1] + BC[cA2];
				} else if (cA1 == cB1) {
					if (BC[cA1] > BC[cA2] && BC[cB1] > BC[cB2]) {
						answer += BC[cA1] + Math.max(BC[cA2], BC[cB2]);
					} else {
						answer += Math.max(BC[cA1], BC[cA2]) + Math.max(BC[cB1], BC[cB2]);
					}
				} else if (cA2 == cB2) {
					if (BC[cA2] > BC[cA1] && BC[cB2] > BC[cB1]) {
						answer += BC[cA2] + Math.max(BC[cA1], BC[cB1]);
					} else {
						answer += Math.max(BC[cA1], BC[cA2]) + Math.max(BC[cB1], BC[cB2]);
					}
				} else if (cA1 == cB2) {
					if (BC[cA1] > BC[cA2] && BC[cB2] > BC[cB1]) {
						answer += BC[cA1] + Math.max(BC[cA2], BC[cB1]);
					} else {
						answer += Math.max(BC[cA1], BC[cA2]) + Math.max(BC[cB1], BC[cB2]);
					}
				} else if (cA2 == cB1) {
					if (BC[cA2] > BC[cA1] && BC[cB1] > BC[cB2]) {
						answer += BC[cA2] + Math.max(BC[cA1], BC[cB2]);
					} else {
						answer += Math.max(BC[cA1], BC[cA2]) + Math.max(BC[cB1], BC[cB2]);
					}
				} else {
					answer += Math.max(BC[cA1], BC[cA2]) + Math.max(BC[cB1], BC[cB2]);
				}
			}
		}
		
		
		// 다음 단계로 이동
		find(count + 1, rowA + d[A[count + 1]][0], colA + d[A[count + 1]][1], rowB + d[B[count + 1]][0], colB + d[B[count + 1]][1]);
	}
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
