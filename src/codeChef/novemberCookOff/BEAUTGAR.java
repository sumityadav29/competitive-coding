package codeChef.novemberCookOff;

import java.util.Arrays;
import java.util.Scanner;

public class BEAUTGAR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			String s = sc.next();
			int len = s.length();
			int index = 0;
			int arr[] = new int[2];
			arr[0] = -1;
			arr[1] = -1;
			
			boolean ans = true;
			int i = 0;
			for ( ; i < len-1; i++) {
				if (s.charAt(i) == s.charAt(i+1)) {
					if (index < 2) {
						arr[index++] = i;
					}else {
						System.out.println("no");
						break;
					}
				}
			}
			if (i != len-1) {
				continue;
			}
			if (s.charAt(len-1) == s.charAt(0)) {
				if (index < 2) {
					arr[index++] = len-1;
				}else {
					System.out.println("no");
					continue;
				}
			}
			if (index == 0) {
				System.out.println("yes");
				continue;
			}else if (index == 1) {
				System.out.println("no");
				continue;
			}else if (index == 2){
				if (s.charAt(arr[0]) != s.charAt(arr[1])) {
					System.out.println("yes");
				}else {
					System.out.println("no");
				}
			}
			
		}
	}
}