import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class D3_2805_농작물수확하기 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D3_2805_농작물수확하기.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int n;
		int[][] arr;
		int sum;
		int m;
		
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			sc.nextLine();
			arr = new int[n][n];
			sum = 0;
			m = n / 2;
			
			for (int i = 0; i < n; i++) {
				String[] s = sc.nextLine().split("");
				for (int j = 0; j < s.length; j++) {
					arr[i][j] = Integer.valueOf(s[j]);
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (i <= m && m - i <= j && m + i >= j) {
						sum += arr[i][j];
					} else if (i > m && i - m <= j && m + (n - i - 1) >= j) {
						sum += arr[i][j];
					}
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}
		
		
	}
}
