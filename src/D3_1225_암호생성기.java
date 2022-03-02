import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/input_D3_1225_암호생성기.txt"));
		Queue<Integer> q = new LinkedList<>();
		String tc;
		String s;
		StringTokenizer st;
		int item;
		boolean check;
		
		while((tc = reader.readLine()) != null) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			check = true;
			
			for (int i = 0; i < 8; i++) {
				q.add(Integer.valueOf(st.nextToken()));
			}
			
			while(check) {
				for (int i = 1; i <= 5; i++) {
					item = q.poll();
					if (item - i > 0) {
						q.add(item - i);
					} else {
						q.add(0);
						check = !check;
						break;
					}
				}
			}
			
			
			System.out.println("#" + tc + " " + print(q));
			q.clear();
		}
	}
	
	public static String print(Queue<Integer> q) {
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			sb.append(q.poll() + " ");
		}
		return sb.toString();
	}
}
