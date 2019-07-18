package codeChef.marchLongChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SUBPRNJL {
	
	static void solve() {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for (int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = i ; j < n ; j++) {
				int temp[] = new int[j-i+1];
				//System.out.println(j-i+1+"  fdfw");
				HashMap<Integer, Integer> map = new HashMap<>();
				for (int t = i ; t <= j ; t++) {
					temp[t-i] = arr[t];
					if (map.containsKey(arr[t])) {
						map.put(arr[t], map.get(arr[t])+1);
					}else {
						map.put(arr[t], 1);
					}
				}
				//System.out.println(Arrays.toString(temp));
				//System.out.println("cbasca");
				Arrays.sort(temp);
				// verify
				int m = (k+j-i)/(j-i+1);
				//System.out.println(m);
				int pos = (k+j-i)/m - (j-i+1);
				int x = temp[pos];
				//System.out.println(x);
				//verify
				int f = map.get(x);
				//System.out.println(f);
				if (map.containsKey(f)) {
					count++;
					//System.out.println(Arrays.toString(temp));
					//System.out.println(x);
					//System.out.println(f);
				}
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
