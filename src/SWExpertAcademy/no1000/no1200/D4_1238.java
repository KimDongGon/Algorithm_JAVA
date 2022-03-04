package SWExpertAcademy.no1000.no1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1238 {
	private static int[][] arr;
	private static int MAX;
	private static final int LEN = 101;
	private static boolean[] visited;
	public static class Node {
		int level;
		int no;
		
		public Node(int level, int no) {
			super();
			this.level = level;
			this.no = no;
		}

		@Override
		public String toString() {
			return "Node [level=" + level + ", no=" + no + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_D4_1238_Contact.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String s;
		StringTokenizer st;
		
		int N, start, tc = 1, from, to;
		
		while((s = reader.readLine()) != null) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(s);
			
			MAX = Integer.MIN_VALUE;
			
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			arr = new int[LEN][LEN];
			visited = new boolean[LEN];
			
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			for (int i = 0; i < N / 2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				arr[from][to] = 1;
			}
			
			dfs(0, new Node(0, start));
			
			tc ++;
			sb.append(MAX).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int cnt, Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(node);
		visited[node.no] = true;
		Node lastNode;
		
		ArrayList<Node> list = new ArrayList<>();
		
		while (!queue.isEmpty()) {
			node = queue.poll();
			
			for (int i = 1; i < LEN; i++) {
				if (!visited[i] && arr[node.no][i] == 1) {
					visited[i] = true;
					lastNode = new Node(node.level + 1, i); 
					queue.add(lastNode);
					list.add(lastNode);
				}
			}
		}
		
		int maxLevel = list.get(list.size() - 1).level;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).level == maxLevel && MAX < list.get(i).no) {
				MAX = list.get(i).no;
			}
		}
	}
}
