package hackerBlocks.nagarroNovember;

import java.util.Arrays;
import java.util.Scanner;

public class TDivisors {
	
	static int divCount(long n, boolean hash[]) 
	{  
	    int total = 1; 
	    for (long p = 2; p <= n; p++)  
	    { 
	        if (hash[p])
	        {  
	            int count = 0; 
	            if (n % p == 0)  
	            { 
	                while (n % p == 0)  
	                { 
	                    n = n / p; 
	                    count++; 
	                } 
	                total = total * (count + 1); 
	                if (total > 3) {
	    	        	return -1;
	    	        }
	            } 
	        } 
	    } 
	    if (total != 3) {
	    	return -1;
	    }
	    return total; 
	} 
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		boolean hash[] = new boolean[1000001]; 
	    Arrays.fill(hash, true); 
	    for (int p = 2; p * p < 1000001; p++) 
	        if (hash[p] == true) 
	            for (int i = p * 2; i < 1000001; i += p) 
	                hash[i] = false;
	    int n = sc.nextInt();
	    for (int i = 0; i < n; i++ ) {
	    	if (divCount(sc.nextLong(), hash) == 3) {
	    		System.out.println("YES");
	    	}else {
	    		System.out.println("NO");
	    	}
	    }
	}
}
