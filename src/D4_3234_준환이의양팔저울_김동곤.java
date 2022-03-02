import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3234_준환이의양팔저울_김동곤 {
	private static int N, answer;
	private static int[] arr;
	private static boolean[] visited;
	private static int left, right;
	private static int sum;
	private static int[] fact;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_D4_3234_준환이의양팔저울.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String s = reader.readLine();
		StringTokenizer st;
		
		int T = Integer.parseInt(s);
		
		fact = new int[10];
		fact[0] = 1;
		fact[1] = 1;
		factorial(9);
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(reader.readLine());
			answer = sum = 0;
			left = right = 0;
			arr = new int[N];
			visited = new boolean[N];
			
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			solve(0);
			
//			System.out.println("#" + tc + " " + answer);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	public static void solve(int cnt) {
		if (cnt == N) {
			answer += 1;
			return;
		}
		
		if (!check()) {
			answer += Math.pow(2, N - cnt) * fact[N - cnt];
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			if (right + arr[i] <= left) {
				visited[i] = true;
				right += arr[i];
				sum -= arr[i];
				solve(cnt + 1);
				sum += arr[i];
				right -= arr[i];	
				visited[i] = false;
			}
			visited[i] = true;
			left += arr[i];
			sum -= arr[i];
			solve(cnt + 1);
			sum += arr[i];
			left -= arr[i];
			visited[i] = false;
		}
	}
	
	public static boolean check() {
		if (sum + right < left) {
			return false;
		}
		return true;
	}
	
	public static void factorial(int n) {
		if (n == 0) {
			return;
		}
		
		factorial(n - 1);
		fact[n] = fact[n - 1] * n;
	}
	
	public static void print(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		
		System.out.println(sb);
	}
}
