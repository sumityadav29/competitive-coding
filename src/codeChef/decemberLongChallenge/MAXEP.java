package codeChef.decemberLongChallenge;

import java.util.Scanner;

public class MAXEP {
	
	int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r>=l) 
        { 
            int mid = l + (r - l)/2; 
  
            // If the element is present at the  
            // middle itself 
            if (arr[mid] == x) 
               return mid; 
  
            // If element is smaller than mid, then  
            // it can only be present in left subarray 
            if (arr[mid] > x) 
               return binarySearch(arr, l, mid-1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid+1, r, x); 
        } 
  
        // We reach here when element is not present 
        //  in array 
        return -1; 
    } 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int x = 0;
		int l = 1;
		int r = n;
		while(true) {
			if (r-l <= 1) {
				System.out.println(1+" "+l);
				x = sc.nextInt();
				if (x == 1) {
					System.out.println(2);
					System.out.println(3+" "+l);
					break;
				}
				System.out.println(1+" "+r);
				if (x == 1) {
					System.out.println(2);
					System.out.println(3+" "+r);
					break;
				}
			}
			System.out.println(1+" "+(r+l)/2);
			x = sc.nextInt();
			if (x == 1) {
				System.out.println(2);
				r = (r+l)/2;
			}
			if (x == 0) {
				l = (r+l)/2;
			}
		}
	}
}
