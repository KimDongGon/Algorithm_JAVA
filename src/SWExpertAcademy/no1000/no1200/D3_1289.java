package SWExpertAcademy.no1000.no1200;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class D3_1289 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_D3_1289_원재의메모리복구하기.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        
        char[] s;
        int len;
        char[] ch;
        int answer = 0;

        for (int i = 0; i < T; i++) {
            s = sc.nextLine().toCharArray();
            len = s.length;
            ch = new char[len];
            Arrays.fill(ch, '0');
            answer = 0;

            for (int j = 0; j < len; j++) {
                if (s[j] != ch[j]) {
                    for (int k = j; k < len; k++) {
                        if (s[j] == '1') {
                            ch[k] = '1';
                        } else {
                            ch[k] = '0';
                        }
                    }
                     answer ++;
                }
            }
            System.out.println("#" + (i + 1) + " " + answer);
        }
	}
}
