package codeChef.decemberLongChallenge;

import java.util.Scanner;

public class CHFINTRO {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		while(n-- > 0) {
			System.out.println(sc.nextInt() >= r?"Good boi":"Bad boi");
		}
	}
}
