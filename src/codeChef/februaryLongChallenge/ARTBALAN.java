package codeChef.februaryLongChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class ARTBALAN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();
			int arr[] = new int[26];
			for(int i = 0 ; i< str.length(); i++) {
				arr[str.charAt(i) - 65]++;
			}
			Arrays.sort(arr);
			long min = Integer.MAX_VALUE;
			for (int i = 1; i<=str.length(); i++) {
				if (str.length()%i != 0) {
					continue;
				}
				long op = 0;
				int f = str.length()/i;
				for (int j = 0; j < i; j++) {
					if (f > arr[26-j-1]) {
						op += Math.abs(arr[26-j-1]-f);
					}
				}
				if (op < min) {
					min = op;
				}
				//System.out.println(i+" "+op);
			}
			System.out.println(min);
		}
	}
}
