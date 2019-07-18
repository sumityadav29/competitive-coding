package hackerBlocks.nagarroOctober;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class setBitSum {
	
	/*static long BitSum(long arr[],int bit) {
		if(arr[bit] != -1) {
			return arr[bit];
		}
		if(bit == 1) {
			return 1;
		}
		long sum = 0;
		for(int i = bit-1; i>0; i--) {
			if(i==bit-1) {
				sum += BitSum(arr, i);
			}else {
				sum += arr[i];
			}
		}
		long temp = sum+(long)Math.pow(2, bit-1);
		arr[bit] = temp;
		return temp;
	}*/
	
	/*static int pop(int x) {
		   int n;
		   n = (x >> 1) & 033333333333;       
		   x = x - n;
		   n = (n >> 1) & 033333333333;       
		   x = x - n;
		   x = (x + (x >> 3)) & 030707070707; 
		   return x%63;
		}*/
	
	static long setBitSum(int ub) {
		if(ub <= 1) {
			return ub;
		}
		int n = Integer.highestOneBit(ub);
		int x = 31 - Integer.numberOfLeadingZeros(n);
		long ans = (x*(long)Math.pow(2, x-1))+1;
		if(ub==0) {
			n = 0;
		}
		/*for(int i = n+1; i<= ub; i++) {
			ans += pop(i);
		}*/
		if(ub - n>0) {
			ans = ans + ub-n + setBitSum(ub-n);
		}
		return ans;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(r.readLine());*/
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			
			/*String s = r.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int lb = Integer.parseInt(st.nextToken());
			int ub = Integer.parseInt(st.nextToken());*/
			int lb = sc.nextInt();
			int ub = sc.nextInt();
			if(lb>=0 && ub>=0) {
				lb = lb==0?0:lb-1;
				System.out.println(setBitSum(ub)-setBitSum(lb));
			}
			else if(lb<0 && ub>=0) {
				lb = Math.abs(lb) - 1;
				System.out.println(((32*lb)-setBitSum(lb))+setBitSum(ub)+32);
			}else {
				int temp = lb;
				lb = Math.abs(ub)-1;
				ub = Math.abs(temp)-1;
				long sub = ub == 0?0:setBitSum(ub);
				long slb = lb == 0?0:setBitSum(lb-1);
				System.out.println((32*(ub-lb+1))-(sub-slb));
			}
			t--;
		}
		
		/*long arr[] = new long[n+1];
		for(int i = 0; i < n+1; i++) {
			arr[i] = -1;
		}
		arr[1] = 1;
		for(int b1 = 1; b1<=n; b1++) {
			ans += BitSum(arr, b1);
		}*/
	}
}
