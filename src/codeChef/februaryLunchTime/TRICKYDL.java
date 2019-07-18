package codeChef.februaryLunchTime;

import java.util.Scanner;

public class TRICKYDL {
	
	public static int binlog( int bits ) // returns 0 for bits=0
	{
	    int log = 0;
	    if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
	    if( bits >= 256 ) { bits >>>= 8; log += 8; }
	    if( bits >= 16  ) { bits >>>= 4; log += 4; }
	    if( bits >= 4   ) { bits >>>= 2; log += 2; }
	    return log + ( bits >>> 1 );
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			
			double d1 = 1;
			double d2 = 1;
			while (a*d1 - Math.pow(2, d1) - 1 > 0) {
				d1++;
			}
			/*while (a - Math.pow(2, d2-1) > 0) {
				d2++;
			}*/
			
			d2 = binlog(a) + 1;
			
			if (a%2 == 0) {
				d2--;
			}
			
			System.out.println(d1-1+" "+ d2 );
		}
	}
}
