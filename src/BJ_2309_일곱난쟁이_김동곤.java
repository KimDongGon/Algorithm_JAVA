import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2309_일곱난쟁이_김동곤 {
	private static int[] arr;
	private static boolean[] visited;
	private static ArrayList<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		visited = new boolean[9];
		list = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		dfs(0, 0);
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void dfs(int cnt, int answer) {
		if (cnt == 7) {
			if (answer == 100) {
				list.clear();
				for (int i = 0; i < 9; i++) {
					if (visited[i]) {
						list.add(arr[i]);
					}
				}
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			dfs(cnt + 1, answer + arr[i]);
			visited[i] = false;
		}
	}
}
