package codeChef.octoberMegaCookOff2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ADASTAIR {
	
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
			int k = sc.nextInt();
			int stairs = 0;
			int temp = sc.nextInt();
			int prev = temp;
			if (temp > k) {
				stairs += temp/k;
				if (temp%k == 0) {
					stairs--;
				}
			}
			
			for (int i = 1; i<n; i++) {
				temp = sc.nextInt();
				if (temp-prev > k) {
					stairs += (temp-prev)/k;
					if ((temp-prev)%k == 0) {
						stairs--;
					}
				}
				prev = temp;
			}
			System.out.println(stairs);
		}
	}
}
