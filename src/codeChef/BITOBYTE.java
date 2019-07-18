package codeChef;

import java.util.Scanner;

public class BITOBYTE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			
			int n = sc.nextInt();
			if(n==0) {
				System.out.println(1+" "+0+" "+0);
				return;
			}
			long bit = 1;
			long nibble = 0;
			long byt = 0;
			
			
			int x =n%26;
			
			if (n>26) {
				int num = n/26;
				if(x!=0) {
					bit = (long)Math.pow(2, num);
				}else {
					bit = (long)Math.pow(2, num-1);
				}
			}
			
			if(x<=2 && x!=0) {
				System.out.println(bit+" "+nibble+" "+byt);
			}else if(x<=10 && x!=0) {
				nibble = bit;
				bit = 0;
				System.out.println(bit+" "+nibble+" "+byt);
			}else {
				nibble = bit;
				bit = 0;
				byt = nibble;
				nibble = 0;
				System.out.println(bit+" "+nibble+" "+byt);
			}
			
			t--;
		}
	}
}
