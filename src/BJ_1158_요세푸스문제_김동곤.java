import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1158_요세푸스문제_김동곤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> list = new ArrayList<>();
		
		int num;
		int count = 1;
		
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		while (!q.isEmpty()) {
			num = q.poll();
			if (count % k == 0) {
				list.add(num);
			} else {
				q.add(num);
			}
			
			count++;
		}
		
		print(list);
	}
	
	public static void print(ArrayList<Integer> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + ", ");
		}
		if (sb.length() > 1) sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}
