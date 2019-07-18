package hackerBlocks.nagarroFebruary;

import java.util.Scanner;

public class Classroom {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long s0 = sc.nextInt();
			long s1 = sc.nextInt();
			int n = sc.nextInt();
			
			long table[] = new long[n+1];
			table[0] = s0;
			table[1] = s1;
			for (int i = 2; i<n+1 ;i++) {
				table[i] = (table[i-1] + table[i-2] + (table[i-1]*table[i-2]))%1000000007;
			}
			System.out.println(table[n]);
		}
	}
}
