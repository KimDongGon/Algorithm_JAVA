import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class D2_2001_파리퇴치 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D2_2001_파리퇴치.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int n, m;
		int[][] arr;
		int sum = 0;
		int temp = 0;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			m = sc.nextInt();
			arr = new int[n][n];
			sum = 0;
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				arr[i] = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			for (int i = 0; i < arr.length - m + 1; i++) {
				for (int j = 0; j < arr.length - m + 1; j++) {
					temp = 0;
					for (int k = i; k < i + m; k++) {
						for (int l = j; l < j + m; l++) {
							temp += arr[k][l];
						}
					}
					
					if (sum < temp) {
						sum = temp;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
