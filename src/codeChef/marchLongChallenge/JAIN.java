package codeChef.marchLongChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class JAIN {
	
	static int mapAsciToInt(int ch) {
		if (ch == 'a') {
			return 0;
		}else if (ch == 'e') {
			return 1;
		}else if (ch == 'i') {
			return 2;
		}else if (ch == 'o') {
			return 3;
		}else {
			return 4;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0 ; i < n ; i++) {
				String str = sc.next();
				int asciSum = 0;
				boolean occured[] = new boolean[5];
				for (int j = 0 ; j < str.length() ; j++) {
					int ch = str.charAt(j);
					int code = mapAsciToInt(ch);
					if (!occured[code]) {
						occured[code] = true;
						asciSum += ch;
					}
				}
				//System.out.println(asciSum);
				if (map.containsKey(asciSum)) {
					map.put(asciSum, map.get(asciSum)+1);
				}else {
					map.put(asciSum, 1);
				}
			}
			
			long goodmeals = 0;
			
			System.out.println(map.keySet());
			//System.out.println('a'+'e'+'i'+'o'+'u');
			
			for (int num1 : map.keySet()) {
				for (int num2 : map.keySet()) {
					if (num2 >= 531 - num1) {
						goodmeals += (map.get(num1)*map.get(num2));
					}
				}
			}
			System.out.println(goodmeals);
		}
	}
}