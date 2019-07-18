package codeChef.snackDown2019OnlineRound1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CHFAR {
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
			int k = sc.nextInt();
			int[] arr  = new int[n];
			int linearSum = 0;
			int squaredSum = 0;
			for (int i = 0;i < n; i++) {
				arr[i] = sc.nextInt();
				linearSum += arr[i];
				squaredSum += Math.pow(arr[i],2);
			}
			Arrays.sort(arr);
			int i = n-1;
			boolean flag = true;
			while(k-- > 0) {
				linearSum = linearSum - arr[i] + 1;
				squaredSum = squaredSum - (int)Math.pow(arr[i],2) + 1;
				//arr[i] = 1;
				if (linearSum >= squaredSum) {
					System.out.println("YES");
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("NO");
			}
		}
	}
}
