import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_5215_햄버거다이어트 {
	private static int T; // 맛 점수
	private static int K; // 제한 칼로리
	private static int N;
	private static int L;
	private static int[] t;
	private static int[] k;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D3_5215_햄버거다이어트.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			T = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			t = new int[N];
			k = new int[N];
			
			for (int i = 0; i < N; i++) {
				t[i] = sc.nextInt();
				k[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) {
				cb(t[i], k[i], i + 1);
			}
			
			System.out.println("#" + test_case + " " + T);
		}
	}
	
	public static void cb(int sumT, int sumK, int idx) {
		if (sumK <= L && sumT > T) {
			T = sumT;
		}
		if (idx > N - 1) {
			return;
		}
		
		for (int i = idx; i < N; i++) {
			cb(sumT + t[i], sumK + k[i], i + 1);
		}
	}
}
