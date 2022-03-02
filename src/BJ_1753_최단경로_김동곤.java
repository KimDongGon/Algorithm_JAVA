import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로_김동곤 {
	private static Node[] adj;
	private static class Node implements Comparable<Node> {
		int to;
		int weight;
		Node link;
		
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + ", link=" + link + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_1753_최단경로.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		int K = Integer.parseInt(reader.readLine()); // 시작점 위치
		
		
		
		boolean[] visited = new boolean[V + 1];
		
		int[] weight = new int[V + 1];
		Arrays.fill(weight, Integer.MAX_VALUE);
		
		int u, v, w; // from, to, weight
		
		adj = new Node[V + 1];
		Node node;
		
		for (int i = 0; i < E; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			node = new Node(v, w);
			node.link = adj[u];
			adj[u] = node;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		weight[K] = 0;
		pq.add(new Node(K, 0));
		
		int idx;
		
		while (!pq.isEmpty()) {
			node = pq.poll();
			idx = node.to;
			
			visited[idx] = true;
			
			for (Node n = adj[idx]; n != null; n = n.link) {
				if (!visited[n.to] && n.weight != 0 && weight[n.to] > weight[idx] + n.weight) {
					weight[n.to] = weight[idx] + n.weight;
					pq.add(new Node(n.to, weight[n.to]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (weight[i] != Integer.MAX_VALUE) {
				System.out.println(weight[i]);
			} else {
				System.out.println("INF");
			}
		}
	}
}