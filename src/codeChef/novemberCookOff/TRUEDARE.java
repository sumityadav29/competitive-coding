package codeChef.novemberCookOff;

import java.util.HashMap;
import java.util.Scanner;

public class TRUEDARE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			HashMap<Integer, Integer> map1 = new HashMap<>();
			HashMap<Integer, Integer> map2 = new HashMap<>();
			int tr = sc.nextInt();
			for (int i = 0; i< tr; i++) {
				map1.put(sc.nextInt(), 0);
			}
			int dr = sc.nextInt();
			for (int i = 0; i< dr; i++) {
				map2.put(sc.nextInt(), 0);
			}
			boolean ans = false;
			int ts = sc.nextInt();
			for (int i = 0; i< ts; i++) {
				int temp = sc.nextInt();
				if (!map1.containsKey(temp)) {
					ans = true;
				}
			}
			int ds = sc.nextInt();
			for (int i = 0; i< ds; i++) {
				int temp = sc.nextInt();
				if (!map2.containsKey(temp)) {
					ans = true;
				}
			}
			if (ans) {
				System.out.println("no");
			}else {
				System.out.println("yes");
			}
		}
	}
}
