package codeChef;

import java.util.Scanner;

public class MINDSUM {
	
	static long min = Integer.MAX_VALUE;
	static int minh = Integer.MAX_VALUE;
	
	public static long digitSum(long n) {
		long sum = 0;
		while (n != 0) 
        { 
            sum = sum + n % 10; 
            n = n/10; 
        } 
		return sum ;
	}
	
	static void minDSum(long n,int h, long d) {
		//System.out.println(h);
		long dsum = digitSum(n);
		if(dsum<min || (dsum==min && h<minh)) {
			min = dsum;
			minh = h+1;
		}
		if(n+d<min || (n+d==min && h<minh)) {
			min = n+d;
			minh = h+1;
		}
		if(h==10) {
			return;
		}
		//System.out.println(h+" "+min+" "+minh);
		if(dsum!=n) {
			minDSum(dsum,h+1,d);
		}
		minDSum(n+d,h+1,d);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			long n = sc.nextLong();
			long d = sc.nextLong();
			min = n;
			minh = 0;
			minDSum(n, 0, d);
			System.out.println(min+" "+minh);
			t--;
		}
	}
}