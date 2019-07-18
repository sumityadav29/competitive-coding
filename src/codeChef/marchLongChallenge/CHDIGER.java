package codeChef.marchLongChallenge;

import java.util.Scanner;

public class CHDIGER {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Long n = sc.nextLong();
			Long d = sc.nextLong();
			String str = n.toString();
			String digit = d.toString();
			int l = str.length();
			while (true) {
				int i = 0;
				str = str + digit;
				boolean flag = false;
				
				for (i = 0; i < str.length()-1 ; i++) {
					if (str.charAt(i) > str.charAt(i+1)) {
						str = str.substring(0, i) + str.substring(i+1, str.length());
						flag = true;
						break;
					}
				}
				if (!flag) {
					str = str.substring(0, str.length()-1);
					break;
				}
			}
			System.out.println(str);
		}
	}
}
