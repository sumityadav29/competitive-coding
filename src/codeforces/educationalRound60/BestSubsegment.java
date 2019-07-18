package codeforces.educationalRound60;

import java.util.Scanner;

public class BestSubsegment {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int  n = sc.nextInt();
		long arr[] = new long[2*n];
		
		for (int i = n ; i < arr.length ; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = n-1 ; i > 0 ; i--) {
			double l = arr[2*i];
			double r = arr[(2*i) + 1];
			double temp = (l+r)/2;
		}
	}
}
