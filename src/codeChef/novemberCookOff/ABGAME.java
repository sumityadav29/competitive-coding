package codeChef.novemberCookOff;

import java.util.Scanner;

public class ABGAME {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			String str = sc.next();
			int n1 = 0;
			int n2 = 0;
			int len = str.length();
			int i = 0;
			for (; i < len-1; i++) {
				if (str.charAt(i) == 'A') {
					if (i%2 != 0) {
						try {
							if (str.charAt(i-1) == '.') {
								n1++;
							}
						}catch (Exception e) {
							
						}
					}else {
						try {
							if (str.charAt(i+1) == '.') {
								n1++;
							}
						} catch (Exception e) {
							
						}
					}
				}else if (str.charAt(i) == 'B') {
					if (i%2 != 0) {
						try {
							if (str.charAt(i-1) == '.') {
								n2++;
							}
						}catch (Exception e) {
							
						}
					}else {
						try {
							if (str.charAt(i+1) == '.') {
								n2++;
							}
						}catch (Exception e) {
							
						}
					}
				}
			}
			System.out.println(n1);
			System.out.println(n2);
			if (n1>=n2) {
				System.out.println("A");
			}else {
				System.out.println("B");
			}
		}
	}
}
