package hackerBlocks.nagarroFebruary;

import java.util.Scanner;

public class ProductSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long m = sc.nextLong();
		
		long p = m;
		long pascal[][] = new long[n][];

		for (int i = 0; i < pascal.length; i++) {
			pascal[i] = new long[i+1];
			for (int j = 0; j < i+1; j++) {
				if (i == j || j == 0) {
					pascal[i][j] = 1;
				}else {
					pascal[i][j] = ((pascal[i-1][j]%p) + (pascal[i-1][j-1]%p))%p;
				}
			}
		}
		
	}
}
