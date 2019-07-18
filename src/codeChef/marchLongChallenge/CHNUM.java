package codeChef.marchLongChallenge;

import java.util.Scanner;

public class CHNUM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int pos = 0;
			int neg = 0;
			for (int i = 0 ; i < n; i++) {
				if (sc.nextInt() >= 0) {
					pos++;
				}else {
					neg++;
				}
			}
			System.out.println(Math.max(pos, neg)+" "+(Math.min(pos, neg) == 0 ? Math.max(pos, neg) : Math.min(pos, neg)));
		}
	}
}
