import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_도영이가만든맛있는음식_김동곤 {
	private static int N;
	private static int MIN = Integer.MAX_VALUE;
	private static int[] A;
	private static int[] B;
	private static int a_sum = 1;
	private static int b_sum = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_2961_도영이가만든맛있는음식.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(reader.readLine());
		A = new int[N];
		B = new int[N];
		
		String s;
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			A[i] = Integer.valueOf(st.nextToken());
			B[i] = Integer.valueOf(st.nextToken());
		}
		
		solve(0, 0);
		
		System.out.println(MIN);
	}
	
	public static void solve(int count, int flag) {
		if (count > N) {
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) continue;
			a_sum *= A[i];
			b_sum += B[i];
			if (Math.abs(b_sum - a_sum) < MIN) {
				MIN = Math.abs(b_sum - a_sum);
			}
			solve(count + 1, (flag | 1 << i));
			a_sum /= A[i];
			b_sum -= B[i];
		}
	}
}
