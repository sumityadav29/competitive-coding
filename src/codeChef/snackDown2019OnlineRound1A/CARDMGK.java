package codeChef.snackDown2019OnlineRound1A;
import java.io.*;
import java.util.*;

public class CARDMGK {
	
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
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int first = sc.nextInt();
			int prev = first;
			int counter = 0;
			int temp = 0;
			for(int i = 1; i<n; i++) {
				temp = sc.nextInt();
				if (prev > temp) {
					counter++;
				}
				prev = temp;
			}
			if (counter > 1) {
				System.out.println("NO");
			}else if (counter == 0) {
				System.out.println("YES");
			}else {
				if (first  >= temp) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
}
