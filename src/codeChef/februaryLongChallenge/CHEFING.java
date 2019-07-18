package codeChef.februaryLongChallenge;

import java.util.Scanner;

public class CHEFING {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			int n = sc.nextInt();
			int freq[] = new int[26];
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				boolean ocd[] = new boolean[26];
				try {
					int j = 0;
					while (true) {
						if (!ocd[str.charAt(j)-97]) {
							freq[str.charAt(j)-97]++;
							ocd[str.charAt(j)-97] = true;
						}
						j++;
					}
				}catch(StringIndexOutOfBoundsException e) {
					
				}
			}
			int count = 0;
			for (int i = 0;i<26;i++) {
				if (freq[i] == n) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
