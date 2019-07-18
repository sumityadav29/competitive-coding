package codeChef.januaryLongChallenge;

import java.util.Scanner;

public class WTCH {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String str = sc.next();
			int i = 0;
			while (i<n && str.charAt(i) != '1') {
				i++;
			}
			if (i >= n) {
				System.out.println((n+1)/2);
				continue;
			}
			int ans = i/2;
			for ( ; i<n ;i = i+2) {
				if (str.charAt(i) != '1') {
					try {
						if(str.charAt(i-1) != '1' && str.charAt(i+1) != '1') {
							ans++;
						}
					}catch(Exception e) {
						try {
							if(str.charAt(i-1) != '1') {
								ans++;
							}
						}catch(Exception ex) {
							if(str.charAt(i+1) != '1') {
								ans++;
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
}
