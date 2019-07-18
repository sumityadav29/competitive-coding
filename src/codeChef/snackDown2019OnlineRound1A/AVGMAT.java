package codeChef.snackDown2019OnlineRound1A;

import java.util.*;
import java.io.*;

public class AVGMAT {
	
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
	
	static int manhattanDist(int i, int j, int m, int n) {
		return Math.abs(i-m)+Math.abs(j-n);
	}
	
	static void calculateManhattan(int i, int j ,String[] arr,int[] preComp) {
		int m = i;
		int n = j;
		j++;
		for (; i<arr.length; i++) {
			for (; j<arr[0].length(); j++) {
				if (arr[i].charAt(j) == '1') {
					//System.out.println(i+" "+j);
					preComp[manhattanDist(i, j, m, n)]++;
				}
			}
			j = 0;
		}
	}
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] preComp = new int[m+n-1];
			String[] arr = new String[n];
			for (int i = 0; i<n; i++) {
				arr[i] = sc.next();
			}
			for (int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if (arr[i].charAt(j) == '1') {
						//System.out.println(i+" "+j);
						calculateManhattan(i,j,arr,preComp);
					}
				}
			}
			for (int i = 1; i<preComp.length; i++) {
				System.out.print(preComp[i]+" ");
			}
			System.out.println();
		}
	}
}
