package SWExpertAcademy.no1000.no1200;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class D3_1244 {
	private static int max;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D3_1244_최대상금.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		char[] num; 
		int count;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			num = sc.next().toCharArray();
			count = sc.nextInt();
			max = -1;
			
			price(num, 0, count);
			
			System.out.println("#" + test_case + " " + max);
		}
			

	}
	
	public static void price(char[] num, int x, int count) {
		if (x == num.length - 1 || count == 0) {
			if (count > 0) {
				if (count % 2 != 0) {
					swap(num, num.length - 1, num.length - 2);
				}
			}
			int m = Integer.valueOf(concat(num));
			if (max < m) {
				max = m;
			}
			return;
		} else {
			char[] newNum;
			for (int i = x + 1; i < num.length; i++) {
				if (num[x] - '0' <= num[i] - '0') {
					newNum = Arrays.copyOf(num, num.length);
					swap(newNum, x, i);
					price(newNum, x, count - 1);
				}
			}
			newNum = Arrays.copyOf(num, num.length);
			price(newNum, x + 1, count);
		}
	}
	
	public static String concat(char[] num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length; i++) {
			sb.append(num[i]);
		}
		return sb.toString();
	}
	
	public static void swap(char[] num, int i, int j) {
		char temp;
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
