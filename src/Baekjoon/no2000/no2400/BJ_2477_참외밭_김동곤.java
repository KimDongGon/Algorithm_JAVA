package Baekjoon.no2000.no2400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2477_참외밭_김동곤 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		StringTokenizer st;
		
		int K = Integer.parseInt(reader.readLine());
		

		ArrayList<String> c = new ArrayList<>();
		ArrayList<Integer> size = new ArrayList<>();
		
		for (int i = 0; i < 6; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			c.add(st.nextToken());
			size.add(Integer.parseInt(st.nextToken()));
		}
		
		while (!(c.get(1) + c.get(2)).equals(c.get(3) + c.get(4))) {
			Collections.rotate(c, 1);
			Collections.rotate(size, 1);
		}
		
		System.out.println(K * (size.get(0) * size.get(5) - size.get(2) * size.get(3)));
	}
}
