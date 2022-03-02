import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class D3_9229_한빈이와SpotMart {
	private static int max;
	private static int[] arr;
	private static int m;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D3_9229_한빈이와SpotMart.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int n;
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			arr = new int[n];
			max = -1;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			if (arr[0] + arr[1] <= m) {
				solve(0, 0, 0);
			} 
			System.out.println("#" + tc + " " + max);
		}
	}
	
	public static void solve(int idx, int sum, int cnt) {
		if (cnt == 2 || idx == arr.length) {
			if (cnt == 2 && sum <= m && sum > max) {
				max = sum;
			}
			return;
		}
		solve(idx + 1, sum + arr[idx], cnt + 1);
		solve(idx + 1, sum, cnt);		
	}
}
