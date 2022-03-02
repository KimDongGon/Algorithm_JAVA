import java.util.Scanner;

public class BJ_2669_직사각형네개의합집합의면적구하기_김동곤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r1, c1, r2, c2;
		
		int[][] arr = new int[101][101];
		
		for (int t = 0; t < 4; t++) {
			r1 = sc.nextInt();
			c1 = sc.nextInt();
			r2 = sc.nextInt();
			c2 = sc.nextInt();
			
			for (int i = r1; i < r2; i++) {
				for (int j = c1; j < c2; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		int answer = 0;
		
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (arr[i][j] == 1) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
