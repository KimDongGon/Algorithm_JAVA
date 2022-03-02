import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D4_1233_사칙연산유효성검사_김동곤2 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D4_1233_사칙연산유효성검사.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n;
		int answer;
		
		StringTokenizer st;
		String s;
		
		for (int tc = 1; tc <= 10; tc++) {
			answer = 1;
			
			n = sc.nextInt();
			sc.nextLine();
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(sc.nextLine());
				st.nextToken();
				s = st.nextToken();
				
				if (st.hasMoreTokens()) {
					if (!isOp(s)) {
						answer = 0;
					}
				} else {
					if (!isNumber(s)) {
						answer = 0;
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static boolean isOp(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}
	
	public static boolean isNumber(String s) {
		try {
			Integer.valueOf(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
