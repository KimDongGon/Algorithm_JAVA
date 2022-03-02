import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BJ_1074_Z_김동곤 {
	private static int N;
	private static int r;
	private static int c;
	private static int answer;
	private static int[][] dir = {
			{0, 0},
			{0, 1},
			{1, -1},
			{0, 1}
	};
	
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("src/input_BJ_1074_Z.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		solve((int)Math.pow(2, N), r, c);
		
		System.out.println(answer);
	}
	
	public static void solve(int N, int r, int c) {
		if (N == 1) {
			return;
		}
		
		if (r < N / 2 && c < N / 2) {
			solve(N / 2, r, c);
		} else if (r < N / 2 && c >= N / 2) {
			answer += (N / 2) * (N / 2);
			solve(N / 2, r, c - N / 2);
		} else if (r >= N / 2 && c < N / 2) {
			answer += (N / 2) * (N / 2) * 2;
			solve(N / 2, r - N / 2, c);
		} else {
			answer += (N / 2) * (N / 2) * 3;
			solve(N / 2, r - N / 2, c - N / 2);
		}
	}
}
