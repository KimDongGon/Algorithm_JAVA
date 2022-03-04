package Baekjoon.no10000.no14000.no14600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14696 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String s;
		StringTokenizer st;

		int N = Integer.parseInt(reader.readLine());

		int[] A;
		int[] B;

		int M, k;

		for (int i = 0; i < N; i++) {
			A = new int[4];
			B = new int[4];

			s = reader.readLine();
			st = new StringTokenizer(s);

			M = Integer.parseInt(st.nextToken());

			for (int j = 0; j < M; j++) {
				k = Integer.parseInt(st.nextToken());
				A[4 - k]++;
			}

			s = reader.readLine();
			st = new StringTokenizer(s);

			M = Integer.parseInt(st.nextToken());

			for (int j = 0; j < M; j++) {
				k = Integer.parseInt(st.nextToken());
				B[4 - k]++;
			}

			boolean flag = true;

			for (int j = 0; j < 4; j++) {
				if (A[j] > B[j]) {
					System.out.println("A");
					flag = false;
					break;
				} else if (A[j] < B[j]) {
					System.out.println("B");
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println("D");
			}
		}
	}
}
