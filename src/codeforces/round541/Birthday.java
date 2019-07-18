package codeforces.round541;

import java.util.Arrays;
import java.util.Scanner;

public class Birthday {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		int ans[] = new int[n];
		
		int pos = n-1;
		int l = (n-1)/2;
		int r = l+1;
		
		ans[l--] = arr[pos--];
		ans[r++] = arr[pos--];
		
		int count = n-2;
		
		//System.out.println(Arrays.toString(ans));
		while (count > 0) {
			
			//if () condition when single left in array
			if (count == 1) {
				try {
					ans[l] = arr[pos];
				}catch(Exception e) {
					ans[r] = arr[pos];
				}
				//System.out.println(Arrays.toString(ans));
				break;
			}
			
			int f = Math.max(Math.abs(ans[l+1] - arr[pos]), Math.abs(ans[r-1] - arr[pos-1]));
			int s = Math.max(Math.abs(ans[l+1] - arr[pos-1]), Math.abs(ans[r-1] - arr[pos]));
			
			//System.out.println(f+" "+s);
			if (f < s) {
				ans[l--] = arr[pos--];
				ans[r++] = arr[pos--];
			}else {
				ans[r++] = arr[pos--];
				ans[l--] = arr[pos--];
			}
			
			count = count - 2;
			//System.out.println(Arrays.toString(ans));
		}
		for (int i = 0 ; i < n ; i++) {
			System.out.print(ans[i]+" ");
		}
	}
}
