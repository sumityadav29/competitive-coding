package codeChef.februaryCookOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TABLET {
	
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
			int b = sc.nextInt();
			int w[] = new int[n];
			int h[] = new int[n];
			int p[] = new int[n];
			
			int max = 0;
			for (int i = 0 ; i < n ; i++) {
				w[i] = sc.nextInt();
				h[i] = sc.nextInt();
				p[i] = sc.nextInt();
				
				if (w[i]*h[i] > max && p[i] <= b) {
					max = w[i]*h[i];
				}
			}
			if (max != 0) {
				System.out.println(max);
			}else {
				System.out.println("no tablet");
			}
		}
	}
}
