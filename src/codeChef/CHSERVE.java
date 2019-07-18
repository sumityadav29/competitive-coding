package codeChef;

import java.util.Scanner;

public class CHSERVE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  t = sc.nextInt();
		
		while(t>0) {
			int chef = sc.nextInt();
			int cook = sc.nextInt();
			int k = sc.nextInt();
			
			int ans = (chef+cook)/k;
			
			if(ans%2 == 0) {
				System.out.println("CHEF");
			}else {
				System.out.println("COOK");
			}
			t--;
		}
	}
}
