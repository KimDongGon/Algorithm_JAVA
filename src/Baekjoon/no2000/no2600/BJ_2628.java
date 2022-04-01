package Baekjoon.no2000.no2600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2628 {
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_2628_종이자르기.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> list = new ArrayList<>();
		ArrayList<int[]> temp = new ArrayList<>();
		list.add(new int[] {0, 0, w, h});
		
		int N = Integer.parseInt(reader.readLine());
		int no, idx, len;
		int[] sq;
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			no = Integer.parseInt(st.nextToken());
			idx = Integer.parseInt(st.nextToken());
			
			len = list.size();
			
			for (int j = 0; j < len; j++) {
				sq = list.get(j);
				
				if (no == 0) {
					if (sq[1] <= idx && idx <= sq[3]) {
						temp.add(new int[] {sq[0], sq[1], sq[2], idx});
						temp.add(new int[] {sq[0], idx, sq[2], sq[3]});
					} else {
						temp.add(sq);
					}
				} else if (no == 1) {
					if (sq[0] <= idx && idx <= sq[2]) {
						temp.add(new int[] {sq[0], sq[1], idx, sq[3]});
						temp.add(new int[] {idx, sq[1], sq[2], sq[3]});
					} else {
						temp.add(sq);
					}
				}
			}
			
			list.clear();
			list.addAll(temp);
			temp.clear();
		}
		
		int MAX = Integer.MIN_VALUE;
		
		for (int i = 0; i < list.size(); i++) {
			sq = list.get(i);
			MAX = Math.max(MAX, (sq[2] - sq[0]) * (sq[3] - sq[1]));
		}
		
		System.out.println(MAX);
	}
}
