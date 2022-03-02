import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564_경비원_김동곤 {
	private static int w, h;
	private static class Pos {
		int row;
		int col;
		
		public Pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_2564_경비원.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(reader.readLine());
		
		
		Pos[] arr = new Pos[N];
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			arr[i] = makePos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		s = reader.readLine();
		st = new StringTokenizer(s);
		
		Pos dong = makePos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Pos mart;
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			mart = arr[i];
			
			if (dong.row == mart.row) {
				if (dong.row == 0 || dong.row == h) {
					answer += Math.abs(dong.col - mart.col);
				} else {
					answer += w + Math.min(dong.row + mart.row, 2 * h - dong.row - mart.row);
				}
			} else if (dong.col == mart.col) {
				if (dong.col == 0 || dong.col == w) {
					answer += Math.abs(dong.row - mart.row);
				} else {
					answer += h + Math.min(dong.col + mart.col, 2 * w - dong.col - mart.col);
				}
			} else {
				if ((dong.row == 0 || dong.row == h) && (mart.row == 0 || mart.row == h)) {
					answer += h + Math.min(dong.col + mart.col, 2 * w - dong.col - mart.col);
				} else if ((dong.col == 0 || dong.col == w) && (mart.col == 0 || mart.col == w)) {
					answer += w + Math.min(dong.row + mart.row, 2 * h - dong.row - mart.row);
				} else {					
					answer += Math.abs(dong.row - mart.row) + Math.abs(dong.col - mart.col);
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static Pos makePos(int dir, int len) {
		if (dir == 1) {
			return new Pos(0, len);
		} else if (dir == 2) {
			return new Pos(h, len);
		} else if (dir == 3) {
			return new Pos(len, 0);
		} else {
			return new Pos(len, w);
		}
	}
}
