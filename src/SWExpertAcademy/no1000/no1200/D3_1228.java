package SWExpertAcademy.no1000.no1200;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D3_1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/input_D3_1228_암호문1.txt"));
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		String len;
		StringTokenizer org_st;
		String s;
		int cmd_len;
		String cmd_s;
		StringTokenizer cmd_st;
		
		String cmd;
		int x;
		int y;
		int val;
		
		LinkedList<Integer> list = new LinkedList<>();
		int tc = 1; 
		
		while (true) {
			len = reader.readLine();
			if (len == null) {
				break;
			}
			
			s = reader.readLine();
			org_st = new StringTokenizer(s);
			
			for (int i = 0; i < Integer.valueOf(len); i++) {
				list.add(Integer.valueOf(org_st.nextToken()));
			}
			
			cmd_len = Integer.valueOf(reader.readLine());
			cmd_s = reader.readLine();
			cmd_st = new StringTokenizer(cmd_s);
			
			for (int i = 0; i < cmd_len; i++) {
				cmd = cmd_st.nextToken();
				x = Integer.valueOf(cmd_st.nextToken());
				y = Integer.valueOf(cmd_st.nextToken());
				for (int j = 0; j < y; j++) {
					val = Integer.valueOf(cmd_st.nextToken());
					list.add(x + j, val);
				}
			}
			
			System.out.println("#" + tc + " " + print(list));
			tc++;
			list.clear();
		}
	}
	
	public static String print(LinkedList<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(list.get(i) + " ");
		}
		
		return sb.toString();
	}
}