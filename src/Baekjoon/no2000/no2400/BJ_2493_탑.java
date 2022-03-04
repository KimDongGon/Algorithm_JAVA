package Baekjoon.no2000.no2400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(reader.readLine());
		Stack<Pair> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n;
		
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(st.nextToken());
			while (!stack.empty() && stack.peek().getNum() < n) {
				stack.pop();
			}
			if (stack.empty()) {
				System.out.print(0 + " ");
			} else {
				System.out.print(stack.peek().getIdx() + " ");
			}
			stack.push(new Pair(i + 1, n));
		}
	}
}

class Pair {
	private int idx;
	private int num;
	
	public Pair(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}