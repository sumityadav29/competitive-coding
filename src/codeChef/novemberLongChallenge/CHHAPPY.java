package codeChef.novemberLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHHAPPY {
	
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
			int arr[] = new int[n+1];
			int arr2[] = new int[n];
			for (int i = 1;i <= n; i++) {
				arr[i] = sc.nextInt();
				arr2[i-1] = arr[i];
			}
			if (n > 1000) {
				boolean flag = false;
				for (int i = 1; i<= n; i++) {
					if (arr[arr[i]] == arr[arr[arr[i]]] && arr[arr[i]] != arr[i]) {
						System.out.println("Truly Happy");
						flag = true;
						break;
					}
				}
				if (!flag) {
					System.out.println("Poor Chef");
				}
			}else {
				int i = 0 ;
				int j = 0;
				for (i =0; i< n; i++ ) {
					for (j = 0;j <n ;j++) {
						if ((arr2[i] != arr2[j]) && arr2[(arr2[i]-1)] == arr2[(arr2[j]-1)]) {
							System.out.println("Truly Happy");
							break;
						}
					}
					if (j != n) {
						break;
					}
				}
				if (i == n && j == n) {
					System.out.println("Poor Chef");
				}
			}
		}
	}
}
