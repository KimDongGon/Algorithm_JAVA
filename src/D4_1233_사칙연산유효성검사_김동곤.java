import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D4_1233_사칙연산유효성검사_김동곤 {
	private static String[] arr;
	private static int n;
	private static int answer;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D4_1233_사칙연산유효성검사.txt"));
		Scanner sc = new Scanner(System.in);
		String[] s;
		
		for (int tc = 1; tc <= 10; tc++) {
			answer = 1;
			
			n = sc.nextInt();
			sc.nextLine();
			arr = new String[n + 1];
			
			for (int i = 1; i <= n; i++) {
				s = sc.nextLine().split(" ");
				arr[i] = s[1];
			}
			
			solve(1);
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static void solve(int count) {
		if (count * 2 <= n) solve(count * 2);
		if (count * 2 + 1 <= n) solve(count * 2 + 1);
		if (count * 2 <= n && count * 2 + 1 <= n) {
			if (isNumber(arr[count * 2]) && isNumber(arr[count * 2 + 1]) && !isNumber(arr[count])) {
				arr[count] = cal(arr[count * 2], arr[count * 2 + 1], arr[count]);
			} else {
				answer = 0;
			}
		}
	}
	
	public static void print(String[] arr) {
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static String cal(String left, String right, String op) {
		int a = Integer.valueOf(left);
		int b = Integer.valueOf(right);		
		if (op.equals("+")) {
			return String.valueOf(a + b);
		} else if (op.equals("-")) {
			return String.valueOf(a - b);			
		} else if (op.equals("*")) {
			return String.valueOf(a * b);			
		} else if (op.equals("/")) {
			if (b == 0) {
				return "1";
			}
			return String.valueOf(a / b);			
		}
		return op;
	}
	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader(new File("src/input_D4_1233_사칙연산유효성검사.txt")));
//		StringTokenizer st;
//		
//		for (int test_case = 1; test_case <= 10; test_case++) {
//			int N = Integer.parseInt(br.readLine());
//			int flag = 1;
//			char current;
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				st.nextToken();
//				current = st.nextToken().charAt(0);
//				
//				if (st.hasMoreTokens()) {
//					if ('0' <= current && current <= '9') flag = 0;
//				} else {
//					if (current < '0' || '9' < current) flag = 0;
//				}
//			}
//			System.out.printf("#%d %d\n", test_case, flag);
//		}
//	}
}
