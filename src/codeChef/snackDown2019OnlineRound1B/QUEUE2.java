package codeChef.snackDown2019OnlineRound1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QUEUE2 {
	
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
			int m = sc.nextInt();
			int k = sc.nextInt();
			int l = sc.nextInt();
			int min = m;
			int minTime = 0;
			
			int arr[] = new int[n];
			for(int i = 0;i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			for (int i = 0; i < n ; i++) {
				if (min >= m+i-(arr[i]/l)) {
					min = m+i-(arr[i]/l);
					minTime = arr[i];
				}
			}
			if (min >= m - k/l + n) {
				min = (m - k/l + n);
				minTime = k;
			}
			//System.out.println(minTime);
			System.out.println(((min+1)*l)-(minTime%l));
		}
	}
}
