import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class D4_1218_괄호짝짓기 {
	private static int N;
	private static char[] s;
	private static int answer;
	private static Stack<Character> stack;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D4_1218_괄호짝짓기.txt"));
		Scanner sc = new Scanner(System.in);
		
		stack = new Stack<>();
		
		char cur;
		char top;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			answer = 1;
			N = sc.nextInt();
			sc.nextLine();
			
			s = sc.nextLine().toCharArray();
			
			for (int i = 0; i < N; i++) {
				cur = s[i];
				if (cur == '(' || cur == '[' || cur == '{' || cur == '<') {
					stack.add(cur);
				} else {
					if (stack.size() == 0) {
						answer = 0;
						break;
					} else {
						top = stack.peek();
						if ((top == '(' && cur == ')') || 
								(top == '[' && cur == ']') ||
								(top == '{' && cur == '}') ||
								(top == '<' && cur == '>')) {
							stack.pop();
						} else {
							answer = 0;
							break;
						}
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
			stack.clear();
		}
	}
}
