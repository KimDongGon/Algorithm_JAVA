import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15686_치킨배달_김동곤 {
	private static int N, M;
	private static ArrayList<Home> hList;
	private static ArrayList<Chicken> cList;
	private static boolean[] visited;
	private static int MIN;
	
	private static class Home {
		int row;
		int col;
		public Home(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	private static class Chicken {
		int row;
		int col;
		
		public Chicken(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_15686_치킨배달.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		hList = new ArrayList<>();
		cList = new ArrayList<>();	
		
		MIN = Integer.MAX_VALUE;
		
		int num;
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < N; j++) {
				num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					hList.add(new Home(i, j));
				} else if (num == 2) {
					cList.add(new Chicken(i, j));
				}
			}
		}
		
		visited = new boolean[cList.size()];
		
		solve(0, 0);
		
		System.out.println(MIN);
	}
	
	public static void solve(int cnt, int start) {
		Home home;
		Chicken chicken;
		if (cnt == M) {
			int temp = 0;
			
			for (int i = 0; i < hList.size(); i++) {
				int min = Integer.MAX_VALUE;
				home = hList.get(i);
				for (int j = 0; j < cList.size(); j++) {
					if (!visited[j]) continue;
					chicken = cList.get(j);
					min = Math.min(min, Math.abs(home.row - chicken.row) + Math.abs(home.col - chicken.col));
				}
				temp += min;
			}
			
			MIN = Math.min(MIN, temp);
			return;
		}
		
		for (int i = start; i < cList.size(); i++) {
			if (visited[i]) continue;
			visited[i] = true;
			solve(cnt + 1, i + 1);
			visited[i] = false;			
		}
	}
}
