package codeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCIRCLES {
	
	static int partition(double arr[], double arr2[], int low, int high) 
    { 
        double pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] <= pivot) 
            { 
            	i++;
                double temp = arr[i]; 
                double temp2 = arr2[i];
                arr[i] = arr[j]; 
                arr2[i] = arr2[j];
                arr[j] = temp; 
                arr2[j] = temp2; 
                
            } 
        } 
        double temp = arr[i+1]; 
        double temp2 = arr2[i+1]; 
        arr[i+1] = arr[high]; 
        arr2[i+1] = arr2[high]; 
        arr[high] = temp; 
        arr2[high] = temp2; 
  
        return i+1; 
    } 
	
    static void sort(double arr[], double arr2[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, arr2, low, high); 
            sort(arr, arr2, low, pi-1); 
            sort(arr, arr2, pi+1, high); 
        } 
    } 
	
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
	
	static void maxMinDist(double arr[][],double arr2[][],int i,int j, int index) {
		double r1 = arr[i][2];
		double r2 = arr[j][2];
		double cdist = Math.sqrt(Math.pow(arr[i][0]-arr[j][0], 2)+Math.pow(arr[i][1]-arr[j][1], 2));
		arr2[1][index] = cdist+r1+r2;
		if(cdist>r1+r2) {
			arr2[0][index] = cdist -r1 -r2;
		}else if(cdist==r1+r2) {
			arr2[0][index] = 0;
		}else if((cdist<(r1+r2))&&(cdist>Math.abs(r1-r2))){
			arr2[0][index] = 0;
		}else if(cdist==Math.abs(r1-r2)) {
			arr2[0][index] = 0;
		}else if(cdist<Math.abs(r1-r2)) {
			arr2[0][index] = Math.max(r1, r2) - Math.min(r1, r2) - cdist;
		}
	}
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		double arr[][] = new double[n][3];
		double arr2[][] = new double[2][(n*(n-1))/2];
		
		for(int i = 0;i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}
		int index = 0;
		for(int i = 0; i<n ;i++) {
			for(int j = i+1;j<n;j++) {
				maxMinDist(arr,arr2,i,j,index++);
			}
		}
		
		//System.out.println(Arrays.toString(arr2[0]));
		sort(arr2[0], arr2[1], 0, arr2[0].length-1);
		
		for(int i = 0; i<q; i++) {
			int k = sc.nextInt();
			int count = 0;
			for(int j = 0;j<arr2[0].length;j++) {
				if(arr2[0][j]>k) {
					break;
				}
				if(arr2[1][j]>=k) {
					count++;
				}
			}
			System.out.println(count);
		}
		
	}
}
