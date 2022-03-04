package SWExpertAcademy.no1000.no1800;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_1873 {
	private static int[][] d = {
			{ -1, 0 },
			{ 1, 0 },
			{ 0, -1 },
			{ 0, 1 }
	};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input_D3_1873_상호의배틀필드.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(reader.readLine());
		int h, w;
		String[] s;
		String[][] map;
		int n;
		int row = 0, col = 0;
		int test_case = 1;

		while(test_case <= T) {
			s = reader.readLine().split(" ");
			map = new String[Integer.valueOf(s[0])][Integer.valueOf(s[1])];

            
			for (int i = 0; i < map.length; i++) {
				map[i] = reader.readLine().split("");
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j].equals("<") || map[i][j].equals(">") || map[i][j].equals("^") || map[i][j].equals("v")) {
						row = i;
						col = j;
					}
				}
			}
			n = Integer.valueOf(reader.readLine());
			
			s = reader.readLine().split("");
			
            
			for (int i = 0; i < s.length; i++) {
				if (s[i].equals("U")) {
					if (row - 1 >= 0 && map[row - 1][col].equals(".")) {
						map[row][col] = ".";
						row--;
					}
					map[row][col] = "^";
				} else if (s[i].equals("D")) {
					if (row + 1 <= map.length - 1 && map[row + 1][col].equals(".")) {
						map[row][col] = ".";
						row++;
					}
					map[row][col] = "v";
				} else if (s[i].equals("L")) {
					if (col - 1 >= 0 && map[row][col - 1].equals(".")) {
						map[row][col] = ".";
						col--;
					}
					map[row][col] = "<";
				} else if (s[i].equals("R")) {
					if (col + 1 <= map[0].length - 1 && map[row][col + 1].equals(".")) {
						map[row][col] = ".";
						col++;
					}
					map[row][col] = ">";
				} 
                else if (s[i].equals("S")){
					if (map[row][col].equals("^")) {
						shoot(map, row, col, 0);
					} else if(map[row][col].equals("v")) {
						shoot(map, row, col, 1);
					} else if(map[row][col].equals("<")) {
						shoot(map, row, col, 2);
					} else if(map[row][col].equals(">")) {
						shoot(map, row, col, 3);
					}
				}
                
			}
			System.out.print("#" + test_case + " ");
			print(map);
			test_case++;
		}
	}
	
	public static void shoot(String[][] map, int row, int col, int idx) {
		while (0 <= row + d[idx][0] && row + d[idx][0] <= map.length - 1 && 0 <= col + d[idx][1] && col + d[idx][1] <= map[0].length - 1) {
			row += d[idx][0];
			col += d[idx][1];
			if (map[row][col].equals("*")) {
				map[row][col] = ".";
				break;
			} else if(map[row][col].equals("#")) {
				break;
			}
		}
	}
	
	public static void print(String[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
