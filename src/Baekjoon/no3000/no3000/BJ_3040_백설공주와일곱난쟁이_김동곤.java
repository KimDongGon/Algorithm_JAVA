package Baekjoon.no3000.no3000;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BJ_3040_백설공주와일곱난쟁이_김동곤 {
	private static int[] arr;
	private static boolean[] visited;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_BJ_3040_백설공주와일곱난쟁이.txt"));
		Scanner sc = new Scanner(System.in);
		
		arr = new int[9];
		visited = new boolean[9];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		solve(0);
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {				
				System.out.println(arr[i]);
			}
		}
	}
	
	public static void solve(int count) {
		if (count == 7) {
			int sum = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}
			
			if (sum == 100) {
				for (int i = 0; i < arr.length; i++) {
					if (!visited[i]) {				
						arr[i] = 0;
					}
				}
			}
			
			return;
		}
		
		for (int i = count; i < 9; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			solve(count + 1);
			visited[i] = false;
		}
	}
}
