package codeChef.acmicpc2018;

import java.util.Arrays;
import java.util.Scanner;

public class REDCGAME {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0) {
			int n = scn.nextInt(), k = scn.nextInt(), ans = 0;
			if(n == 1) {
				System.out.println(scn.nextInt());
				continue;
			}
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
				if(arr[i] > k) {
					arr[i] -= k;
					ans += k;
				} else {
					ans += arr[i];
					arr[i] = 0;
				}
			}
			Arrays.sort(arr);
			int sum = 0;
			for(int i = 0; i < n - 2; i++) {
				sum += arr[i];
			}
			if(arr[n - 2] >= sum) {
				ans += arr[n - 1] - (arr[n - 2] - sum);
			} else {
				sum += arr[n - 2];
				ans += arr[n - 1] - sum % 2;
			}
			System.out.println(ans);
		}
	}
	/*static void func(int[] arr, int start, int end, int k) {
		if (end-start == 2) {
			int min = arr[start+1]-k;
			arr[start+1] = k;
			arr[end] = arr[end]-min;
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			return;
		}
		
		if (end-start == 1) {
			int min = arr[start] - k;
			arr[start] = k;
			arr[end] = arr[end] - min;
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			return;
		}
		
		int sum  =0;
		for(int i =start ;i <=end; i++) {
			sum += arr[i]-k;
		}
		if (sum%k == 0) {
			for (int i = start ;i<=end; i++) {
				arr[i] = k;
			}
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			return;
		}else {
			
			func(arr,start+1,end-1,k);
			//System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n =sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[n];
			int num = 0;
			
			for(int i = 0; i< n; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] > k) {
					num++;
				}
			}
			
			if (n==2 && num==2) {
				System.out.println(k+arr[1]-(arr[0]-k));
				continue;
			}
			
			Arrays.sort(arr);
			int start  = n-num;
			//send index start +1 and end-1;
			func(arr,start,n-2,k);
			Arrays.sort(arr);
			if (arr[n-2] != k) {
				int min = arr[n-2]-k;
				arr[n-2] = k;
				arr[n-1] = arr[n-1] - min;
			}
			int ans = 0;
			for (int i = 0;i < n;i++) {
				ans += arr[i];
			}
			//System.out.println(Arrays.toString(arr));
			System.out.println(ans);
		}
	}*/
	
	/*static void func(int[] arr, int start, int end, int k) {
		if (end-start == 2) {
			int min = arr[start+1]-k;
			arr[start+1] = k;
			arr[end] = arr[end]-min;
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			return;
		}
		
		if (end-start == 1) {
			int min = arr[start] - k;
			arr[start] = k;
			arr[end] = arr[end] - min;
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			return;
		}
		
		int sum  =0;
		for(int i =start ;i <=end; i++) {
			sum += arr[i]-k;
		}
		if (sum%k == 0) {
			for (int i = start ;i<=end; i++) {
				arr[i] = k;
			}
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			return;
		}else {
			
			func(arr,start+1,end-1,k);
			//System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n =sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[n];
			int num = 0;
			
			for(int i = 0; i< n; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] > k) {
					num++;
				}
			}
			
			Arrays.sort(arr);
			int start  = n-num;
			//send index start +1 and end-1;
			func(arr,start+1,n-2,k);
			Arrays.sort(arr);
			if (arr[n-2] != k) {
				int min = arr[n-2]-k;
				arr[n-2] = k;
				arr[n-1] = arr[n-1] - min;
			}
			int ans = 0;
			for (int i = 0;i < n;i++) {
				ans += arr[i];
			}
			System.out.println(Arrays.toString(arr));
			System.out.println(ans);
		}
	}*/
}
