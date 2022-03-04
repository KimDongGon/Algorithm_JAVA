package SWExpertAcademy.no3000.no3400;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class D3_3499 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D3_3499_퍼펙트셔플.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int n;
		ArrayList<String> arr;
		ArrayList<String> sub_arr;
		ArrayList<String> sub_arr2;
		
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			arr = new ArrayList<>();
			sub_arr = new ArrayList<>();
			sub_arr2 = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				if (i < (n + 1) / 2) {
					sub_arr.add(sc.next());
				} else {
					sub_arr2.add(sc.next());
				}
			}
			
			
			for (int i = 0; i < (n / 2) + 1; i++) {
				if (i < sub_arr.size() && sub_arr.get(i) != null) {
					arr.add(sub_arr.get(i));
				}
				if (i < sub_arr2.size() && sub_arr2.get(i) != null) {
					arr.add(sub_arr2.get(i));
				}
			}
			
			
			
			System.out.println("#" + tc + " " + print(arr));
		}
	}
	public static String print(ArrayList<String> arr) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i) + " ");
		}
		
		return sb.toString();
	}
}
