package SWExpertAcademy.no3000.no3100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D4_3124 {
    private static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }


        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        String s;
        StringTokenizer st;

        int V, E, from, to, weight;
        long answer;
        boolean[] visited;
        ArrayList<Node>[] arr;
        PriorityQueue<Node> queue;

        for (int tc = 1; tc <= T; tc++) {
            s = reader.readLine();
            st = new StringTokenizer(s);

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visited = new boolean[V + 1];
            visited[0] = true;

            arr = new ArrayList[V + 1];
            answer = 0;

            for (int i = 0; i < E; i++) {
                s = reader.readLine();
                st = new StringTokenizer(s);

                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                if (arr[from] == null) {
                    arr[from] = new ArrayList<>();
                }
                arr[from].add(new Node(from, to, weight));

                if (arr[to] == null) {
                    arr[to] = new ArrayList<>();
                }
                arr[to].add(new Node(to, from, weight));
            }

            queue = new PriorityQueue<>();
            queue.add(new Node(1, 1, 0));

            Node node;
            int len;

            while (!queue.isEmpty()) {
                node = queue.poll();
                if (!visited[node.to]) {
                    visited[node.to] = true;
                    answer += node.weight;
                    if (arr[node.to] != null) {
                        len = arr[node.to].size();

                        for (int i = 0; i < len; i++) {
                            if (!visited[arr[node.to].get(i).to]) {
                                queue.add(arr[node.to].get(i));
                            }
                        }
                    }
                }

            }


            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
