import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1828_냉장고_김동곤 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_JO_1828_냉장고.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(reader.readLine());
		
		int answer = 0;
		int cur = 0;
		
		String s;
		StringTokenizer st;
		
		Product[] p = new Product[N];
		
		int l_temp;
		int h_temp;
		
		for (int i = 0; i < N; i++) {
			s = reader.readLine();
			st = new StringTokenizer(s);
			
			l_temp = Integer.valueOf(st.nextToken());
			h_temp = Integer.valueOf(st.nextToken());
			
			p[i] = new Product(l_temp, h_temp);
		}
		
		Arrays.sort(p);
		
		for (int i = 0; i < p.length; i++) {
			if (i == 0) {
				cur = p[i].h_temp;
				answer ++;
			} else {
				if (p[i].l_temp > cur) {
					answer++;
					cur = p[i].h_temp;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static void print(Product[] p) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < p.length; i++) {
			sb.append(p[i].l_temp).append(" ").append(p[i].h_temp).append("\n");
		}
		System.out.println(sb.toString());
	}
}

class Product implements Comparable<Product>{
	int l_temp;
	int h_temp;
	
	public Product(int l_temp, int h_temp) {
		this.l_temp = l_temp;
		this.h_temp = h_temp;
	}

	@Override
	public int compareTo(Product o) {
		return this.h_temp - o.h_temp;
	}
	
	
}