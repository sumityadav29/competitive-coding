package codeChef.februaryLongChallenge;

import java.util.Scanner;

public class MAGICJAR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			int n = sc.nextInt();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				int temp = sc.nextInt();
				if (temp > max) {
					max = temp;
				}
			}
			System.out.println(max);
		}
	}
}
