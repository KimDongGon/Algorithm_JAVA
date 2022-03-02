import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1224_계산기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/input_D4_1224_계산기3.txt"));
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		char[] str;
		StringBuffer sb;
		int sum;
		Stack<Integer> stack = new Stack<>();
		Stack<Character> toStack = new Stack<>();
		char token;
		int num1, num2;
		int tc = 1;
		
		while ((s = reader.readLine()) != null) {
			str = reader.readLine().toCharArray();
			sb = new StringBuffer();
			stack.clear();
			toStack.clear();
			
			for (int i = 0; i < Integer.valueOf(s); i++) {
				token = str[i];
				if (Character.isDigit(token)) {
					sb.append(token);
				} else {
					if (toStack.isEmpty()) {
						toStack.add(token);
					} else {
						if (token == '+') {
							if (toStack.peek() == '+') {
								sb.append(token);
							} else {
								while(!toStack.isEmpty() && toStack.peek() != '(') {
									sb.append(toStack.pop());
								}
								toStack.add(token);
							}
						} else if (token == '*') {
							while(!toStack.isEmpty() && toStack.peek() == '*') {
								sb.append(toStack.pop());
							}
							toStack.add(token);
						} else if (token == '(') {
							toStack.add(token);
						} else if (token == ')') {
							while(!toStack.isEmpty()) {
								if (toStack.peek() == '(') {
									toStack.pop();
									break;
								}
								sb.append(toStack.pop());
							}
						}
					}
				}
			}
			
			while (!toStack.isEmpty()) {
				sb.append(toStack.pop());
			}
			
			str = sb.toString().toCharArray();
			
			
			for (int i = 0; i < str.length; i++) {
				token = str[i];
				if (Character.isDigit(token)) {
					stack.add(token - '0');
				} else {
					if (token == '+') {
						num1 = stack.pop();
						num2 = stack.pop();
						stack.push(num1 + num2);
					} else if (token == '*') {
						num1 = stack.pop();
						num2 = stack.pop();
						stack.push(num1 * num2);
					}
				}
			}
			sum = stack.pop();
			System.out.println("#" + tc + " " + sum);
			tc++;
		}
	}
}
