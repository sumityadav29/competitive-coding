package codeChef.snackDown2019Qualifier;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class QualPrel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int sum = k;
			ArrayList<Integer> arr = new ArrayList<Integer>(n);
			for(int i = 0;i <n; i++) {
				arr.add(sc.nextInt());
			}
			Collections.sort(arr);
			Collections.reverse(arr);
			System.out.println(arr.toString());
			int j = k;
			while(j<n) {
				if(arr.get(j) == arr.get(k-1)) {
					sum++;
					j++;
				}else {
					break;
				}
			}
			System.out.println(sum);
			t--;
		}
	}
}
