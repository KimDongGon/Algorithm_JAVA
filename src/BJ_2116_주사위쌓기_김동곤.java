import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2116_주사위쌓기_김동곤 {
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_2116_주사위쌓기.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st;
		
		int N = Integer.parseInt(s);
		
		int[][] dice = new int[N][6];
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] pos = { 5, 3, 4, 1, 2, 0 };
		
		int up, down;
		ArrayList<Integer> list = new ArrayList<>();
		int MAX = Integer.MIN_VALUE;
		int answer;
		
		for (int i = 0; i < 6; i++) {
			up = i;
			down = pos[i];
			answer = 0;
			
			for (int j = 0; j < 6; j++) {
				if (j != up && j != down) {						
					list.add(dice[0][j]);
				}
			}
			answer += Collections.max(list);
			list.clear();
			
			for (int j = 1; j < N; j++) {
				for (int k = 0; k < 6; k++) {
					if (dice[j - 1][up] == dice[j][k]) {
						up = pos[k];
						down = k;
						break;
					}
				}
				for (int l = 0; l < 6; l++) {
					if (l != up && l != down) {						
						list.add(dice[j][l]);
					}
				}
				
				answer += Collections.max(list);
				list.clear();
			}
			
			MAX = Integer.max(MAX, answer);
		}
		
		System.out.println(MAX);
	}
}
