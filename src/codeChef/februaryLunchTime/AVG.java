package codeChef.februaryLunchTime;

import java.util.Scanner;

public class AVG {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0 ) {
			double n = sc.nextInt();
			double k = sc.nextInt();
			double v = sc.nextInt();
			
			double sn = 0;
			for (int i = 0 ; i < n ; i++) {
				sn = sn + sc.nextInt();
			}
			
			if (k > n) {
				System.out.println(-1);
				continue;
			}
			
			double ans = ((v*(n+k)) - sn)/k;
			
			if (ans > 0 && ((sn+(k*ans))/(n+k) == v) && ans%1 == 0) {
				System.out.println(ans);
			}else {
				System.out.println(-1);
			}
		}
	}
}
