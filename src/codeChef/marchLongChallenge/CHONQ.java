package codeChef.marchLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHONQ {
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			
			long arr[] = new long[n];
			
			for (int i = 0 ; i < n ; i++) {
				arr[i] = sc.nextLong();
			}
			
			long ans[][] = new long[n][];
			for (int i = 0 ; i < n ; i++) {
				ans[i] = new long[i+1];
				for (int j = ans[i].length ; j > 0 ; j--) {
					ans[i][j] = ans[i-1][j] + arr[i]/j;
				}
			}
		}
	}
}