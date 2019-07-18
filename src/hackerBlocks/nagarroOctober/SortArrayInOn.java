package hackerBlocks.nagarroOctober;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SortArrayInOn{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		HashMap<Integer,Integer> map = new HashMap<>();
		
		while(t>0) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			for(int i = 0; i<n;i++) {
				int temp = sc.nextInt();
				if(map.containsKey(temp)) {
					map.put(temp, map.get(temp)+1);
				}else {
					map.put(temp, 1);
				}
			}
			for(int i = s; i<=e; i++) {
				if(map.containsKey(i)) {
					for (int j = 0; j<map.get(i);j++){
						System.out.print(i+" ");
					}
				}
			}
			t--;
			System.out.println();
		}
	}
}
