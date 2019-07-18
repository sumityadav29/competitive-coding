package codeforces.educationalRound60;

import java.util.Scanner;

public class Emotes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		long k = sc.nextInt();
		
		long l = Integer.MIN_VALUE;
		long sl = Integer.MIN_VALUE;
		for (int i = 0 ; i < n ; i++) {
			long temp = sc.nextInt();
			if (temp >= l) {
				sl = l;
				l = temp;
			}else if (temp > sl) {
				sl = temp;
			}
		}
		long ans = 0;
		long temp = m/(k+1);
		long j = m - (temp*(k+1));
		
		ans = ((k*l) + (sl))*temp + (j*l);
	
		//System.out.println(l);
		//System.out.println(sl);
		System.out.println(ans);
	}
}
