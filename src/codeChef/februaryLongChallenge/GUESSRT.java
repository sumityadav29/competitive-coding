package codeChef.februaryLongChallenge;

import java.util.Scanner;

public class GUESSRT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			double n = sc.nextInt();
			double k = sc.nextInt();
			double m = sc.nextInt();
			double n1 = n;
			double n2 = n;
			
			int p = 0;
			int q = 0;
			double pb = 0;
			
			boolean first = false;
			while (m-- > 0) {
				if (m == 0 || n2 <= k) {
					if (!first) {
						pb = 1/n2;
						first = true;
						n1 = n2;
						n2 = n2+k;
					}else {
						pb = pb + ((n1-1)/(n1*n2));
						n1 = n2;
						n2 = n2+k;
					}
				}else {
					double rem = n2%k;
					double x = (n2/k) - (rem/k);
					n1 = n2;
					n2 = n2 - (x*k);
				}
				System.out.println(pb);
			}
			System.out.println(pb);
			System.out.println();
		}
	}
}
