import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_6808_규영이와인영이의카드게임_김동곤 {
	private static int win;
	private static int lose;
	private static int[] gyu;
	private static int[] inn;
	private static int[] arr;
	private static int a_idx;
	private static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/D3_6808_규영이와인영이의카드게임.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(reader.readLine());
		
		String s;
		StringTokenizer st;
		boolean check;
		int idx;
		
		for (int tc = 1; tc <= T; tc++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			win = 0;
			lose = 0;
			gyu = new int[9];
			inn = new int[9];
			arr = new int[9];
			a_idx = 0;
			visited = new boolean[9];
			idx = 0;
			
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.valueOf(st.nextToken());
			}
			
			for (int i = 1; i <= 18; i++) {
				check = false;
				for (int j = 0; j < gyu.length; j++) {
					if (gyu[j] == i) {
						check = true;
						break;
					}
				}
				
				if(!check) {
					inn[idx++] = i;
				}
			}
			
			solve(0);
			
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}
	
	public static void solve(int count) {
		if (count == 9) {
			game();
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[a_idx++] = inn[i];
				solve(count + 1);
				a_idx--;
				visited[i] = false;
			}
		}
	}
	
	public static void game() {
		int win_sum = 0;	
		int lose_sum = 0;	
		for (int i = 0; i < 9; i++) {
			if (gyu[i] > arr[i]) {
				win_sum += gyu[i] + arr[i];
			} else {
				lose_sum += gyu[i] + arr[i];
			}
		}
		
		if (win_sum > lose_sum) {
			win++;
		} else {
			lose++;
		}
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
