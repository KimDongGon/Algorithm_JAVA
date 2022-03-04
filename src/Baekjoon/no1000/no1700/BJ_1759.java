package Baekjoon.no1000.no1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1759 {
	private static int L;
	private static char[] alpha;
	private static StringBuilder sb;
	private static boolean[] visited;
	private static List<String> list;
	private static char[] m = {'a', 'e', 'i', 'o', 'u'};
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_1759_암호만들기.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<String>();
		
		alpha = new char[C];
		
		sb = new StringBuilder();
		visited = new boolean[C];
		
		s = reader.readLine();
		st = new StringTokenizer(s);
		
		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		solve(0);
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void solve(int cnt) {
		if (cnt == L) {
			int mo = check();
			int ja = L - mo;
			if (mo > 0 && ja > 1) {				
				list.add(sb.toString());
			}
			return;
		}
		
		for (int i = 0; i < alpha.length; i++) {
			if (visited[i]) continue;
			if (sb.length() == 0 || (sb.length() > 0 && sb.charAt(sb.length() - 1) < alpha[i])) {				
				visited[i] = true;
				sb.append(alpha[i]);
				solve(cnt + 1);
				sb.setLength(sb.length() - 1);
				visited[i] = false;
			}
		}
	}
	
	public static int check() {
		int cnt = 0;
		for (int i = 0; i < sb.length(); i++) {
			for (int j = 0; j < m.length; j++) {
				if (sb.charAt(i) == m[j]) {
					cnt ++;
				}
			}
		}
		return cnt;
	}
}
