package Baekjoon.no10000.no16000.no16200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16236 {
	private static int N, answer, row, col, cnt, weight;
	private static int[][] map;
	private static int[][] dir = {
			{ -1, 0 },
			{ 0, -1 },
			{ 1, 0 },
			{ 0, 1 }
	};
	private static boolean[][] visited;
	private static class Node implements Comparable<Node>{
		int row;
		int col;
		
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public int compareTo(Node o) {
			if (this.row == o.row) {
				return Integer.compare(this.col, o.col);
			} else {
				return Integer.compare(this.row, o.row);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_16236_아기상어.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		StringTokenizer st;
		
		int val;
		
		N = Integer.parseInt(reader.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		weight = 2;
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < N; j++) {
				val = Integer.parseInt(st.nextToken());
				if (val == 9) {
					row = i;
					col = j;
					visited[i][j] = true;
				} else {
					map[i][j] = val;
				}
			}
		}
		
		bfs();
		
		System.out.println(answer);
	}
	
	public static void bfs() {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		PriorityQueue<Node> tempQueue = new PriorityQueue<Node>();
		
		queue.add(new Node(row, col));
		Node cur;
		int _row, _col, moveCnt = 0, size;
		
		while (!queue.isEmpty()) {
			if (check()) {
				answer += moveCnt;
				break;
			}
			
			size = queue.size();
			moveCnt++;
			
			// 한 칸씩 진행
			for (int i = 0; i < size; i++) {
				cur = queue.poll();
				
				for (int[] d : dir) {
					_row = cur.row + d[0];
					_col = cur.col + d[1];
					
					if (0 <= _row && _row < N && 0 <= _col && _col < N && !visited[_row][_col]) {						
						tempQueue.add(new Node(_row, _col));
						visited[_row][_col] = true;
					}
				}
			}
			
			queue.addAll(tempQueue);
			tempQueue.clear();
			
			size = queue.size();
			
			// 우선순위에 따라 먹을 수 있는 물고기가 존재하는지 체크
			for (int i = 0; i < size; i++) {
				cur = queue.poll();
				
				// 다음 경로가 길이 아닌 경우
				if (map[cur.row][cur.col] != 0) {
					// 먹을 수 있는 물고기인 경우
					if (map[cur.row][cur.col] < weight) {
						if (++ cnt == weight) {
							weight ++;
							cnt = 0;
						}
						row = cur.row;
						col = cur.col;
						
						map[row][col] = 0;
						
						answer += moveCnt;
						moveCnt = 0;
						
						queue.clear();
						tempQueue.clear();
						tempQueue.add(new Node(row, col));
						visited = new boolean[N][N];
						visited[row][col] = true;
						
						break;
					// 상어와 무게가 같은 물고기인 경우 -> 그냥 이동
					} else if (map[cur.row][cur.col] == weight) {
						tempQueue.add(cur);
					}
				// 다음 경로가 길인 경우 -> 그냥 이동
 				} else {
 					tempQueue.add(cur);
				}
			}
			
			queue.addAll(tempQueue);
			tempQueue.clear();
		}
	}
	
	// 맵 전체에 상어가 먹을 수 있는 물고기가 존재하는지 체크하는 함수
	public static boolean check() {
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && map[i][j] < weight) {
					flag = true;
				}
			}
		}
		
		if (flag) {
			return false;
		}
		return true;
	}
}
