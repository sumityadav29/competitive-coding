package codeforces.round541;

import java.util.Scanner;

public class SeaBattle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long w1,h1,w2,h2;
		w1 = sc.nextInt();
		h1 = sc.nextInt();
		w2 = sc.nextInt();
		h2 = sc.nextInt();
		
		long ans = 2*(h1+h2) + w1+w2;
		
		if (w1 == w2) {
			System.out.println(ans + 4);
		}else {
			System.out.println(ans + 4 + w1 - w2);
		}
		
	}
}
