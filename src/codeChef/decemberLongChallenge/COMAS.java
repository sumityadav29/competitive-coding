package codeChef.decemberLongChallenge;

import java.util.Scanner;

public class COMAS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			boolean arr[] = new boolean[n];
			int x = n;
			while (x > 6) {
				int c = 0;
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i< n; i++) {
					sb.append("? ");
					if (!arr[i]) {
						sb.append(i+1+" ");
						c++;
					}
					if (c == 5) {
						System.out.println(sb);
						break;
					}
				}
				arr[sc.nextInt()] = true;
				arr[sc.nextInt()] = false;
			}
		}
	}
}
