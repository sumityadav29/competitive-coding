package codeChef.octoberMegaCookOff2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PUMPWAT {
	
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
	
	static int findMaxIndex(int[] arr, int l, int r) {
		int max = Integer.MIN_VALUE;
		int maxi = l;
		if (l<=r) {
			for (int i = l; i <= r; i++) {
				if (arr[i] > max) {
					max = arr[i];
					maxi = i;
				}
			}
		}
		return maxi;
	}
	
	static int reservoir(int[] arr, int l, int r) {
		if (l < 0 || r > arr.length-1) {
			return 0;
		}
		int maxi = findMaxIndex(arr,l,r);
		if (l == maxi || r == maxi) {
			return 1;
		}
		return 1+Math.min(reservoir(arr, l, maxi-1), reservoir(arr, maxi+1, r));
		
	}
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(reservoir(arr, 0, n-1));
		}
	}
}
