package codeChef.februaryLongChallenge;

import java.util.Scanner;

public class DEPCHEF {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			int d[] = new int[n];
			
			for (int i = 0; i< n; i++) {
				a[i] = sc.nextInt();
			}
			
			for (int i = 0; i< n; i++) {
				d[i] = sc.nextInt();
			}
			
			int maxd = Integer.MIN_VALUE;
			for (int i = 0; i<n; i++) {
				if (i == 0) {
					if (d[i] > a[1]+a[n-1] && d[i] > maxd) {
						maxd = d[i];
					}
				}else if (i == n-1) {
					if (d[i] > a[n-2]+a[0] && d[i] > maxd) {
						maxd = d[i];
					}
				}else {
					if (d[i] > a[i-1]+a[i+1] && d[i] > maxd) {
						maxd = d[i];
					}
				}
			}
			if (maxd != Integer.MIN_VALUE) {
				System.out.println(maxd);
			}else {
				System.out.println("-1");
			}
		}
	}
}
