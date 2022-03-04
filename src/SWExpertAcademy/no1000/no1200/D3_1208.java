package SWExpertAcademy.no1000.no1200;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public class D3_1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader reader = new BufferedReader(new FileReader("src/input_D3_1208_Flatten.txt"));
		
		int n;
		Vector<Integer> v = new Vector<>();
		String[] s;
		int min, max;
		int answer;
		
		for (int tc = 1; tc <= 10; tc++) {
			n = Integer.parseInt(reader.readLine());
			s = reader.readLine().split(" ");
			
			for (int i = 0; i < s.length; i++) {
				v.add(Integer.parseInt(s[i]));
			}
			
			while (true) {
				Collections.sort(v);
				min = v.firstElement();
				max = v.lastElement();
				
				v.set(0, min + 1);
				v.set(v.size() - 1, max - 1);
				n--;
				
				if (n <= 0) {
					Collections.sort(v);
					min = v.firstElement();
					max = v.lastElement();
					answer = max - min;
					break;
				}

			}
			
			System.out.println("#" + tc + " " + answer);
			v.clear();
		}
	}
	
}
