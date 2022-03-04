package SWExpertAcademy.no1000.no1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1251 {
	private static boolean[] visited;
	private static int[][] arr;
	private static double answer;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_D4_1251_하나로.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int T = Integer.parseInt(st.nextToken());
		int N;
		double[] minEdge;
		double min;
		int minV;
		int x1, y1, x2, y2;
		double E, len;
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			answer = 0;
			
			N = Integer.parseInt(reader.readLine());
			arr = new int[N][2];
			minEdge = new double[N];
			visited = new boolean[N];
			
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int i = 0; i < N; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				minEdge[i] = Double.MAX_VALUE;
			}
			
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int i = 0; i < N; i++) {
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(reader.readLine());
			
			minEdge[0] = 0;
			
			for (int i = 0; i < N; i++) {
				min = Double.MAX_VALUE;
				minV = 0;
				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > minEdge[j]) {
						min = minEdge[j];
						minV = j;
					}
				}
				
				visited[minV] = true;
				answer += min;
				
				for (int j = 0; j < N; j++) {
					if(!visited[j]) {
						x1 = arr[minV][0];
						y1 = arr[minV][1];
						x2 = arr[j][0];
						y2 = arr[j][1];
						
						len = Math.pow((x2 - x1), 2) + Math.pow(y2 - y1, 2);
						
						if (minEdge[j] > len) {
							minEdge[j] = len;
						}
					}
				}
			}

			sb.append(Math.round(answer * E)).append("\n");
		}
		
		System.out.println(sb);
	}
}
