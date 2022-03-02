import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_1786_찾기_김동곤 {
	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/input_BJ_1786_찾기.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		char[] text = reader.readLine().toCharArray();
		char[] pattern = reader.readLine().toCharArray();
		
		int tLen = text.length;
		int pLen = pattern.length;
		
		int[] arr = new int[pLen];
		
		for (int i = 1, j = 0; i < pLen; i++) {
			while(j > 0 && pattern[i] != pattern[j]) j = arr[j - 1];
			
			if (pattern[i] == pattern[j]) {
				arr[i] = ++j;
			} else {
				arr[i] = 0;
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0, j = 0; i < tLen; i++) {
			while (j > 0 && text[i] != pattern[j]) j = arr[j - 1];
			
			if (text[i] == pattern[j]) {
				if (j == pLen - 1) {
					cnt ++;
					list.add(i + 2 - pLen);
					j = arr[j];
				} else {
					j++;
				}
			}
		}
		
		sb.append(cnt).append("\n");
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
