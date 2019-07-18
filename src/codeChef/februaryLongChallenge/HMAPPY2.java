package codeChef.februaryLongChallenge;

import java.util.Scanner;

public class HMAPPY2 {
	
	static long gcd(long a, long b) {  
        if (a == 0 || b == 0) 
           return 0; 
        if (a == b) 
            return a;  
        if (a > b) 
            return gcd(a-b, b); 
        return gcd(a, b-a); 
    } 
      
    static long lcm(long a, long b) { 
        return (a*b)/gcd(a, b); 
    }
	
	/*static long lcm(long a, long b, long n) {
		
		long lcm = 0;
		long g = a>b?a:b;
		long l = a<b?a:b;
		
		if (g%l == 0) {
			return g;
		}
		int i = 2;
		while (g <= n) {
			lcm = g*i;
			if (lcm%l == 0) {
				return lcm;
			}
			i++;
		}
		return n+1;
	}*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			long n = sc.nextLong();
			long a = sc.nextInt();
			long b = sc.nextInt();
			long k = sc.nextLong();
			
			long lcm = lcm(a,b);
			
			a = n/a;
			b = n/b;
			
			lcm = n/lcm;
			
			if (a+b-lcm-lcm >= k) {
				System.out.println("Win");
			}else {
				System.out.println("Lose");
			}
			
		}
	}
}
