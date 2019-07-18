package hackerBlocks.nagarroOctober;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KohliMonk {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		ArrayList<Integer> al = new ArrayList<>(n);
		ArrayList<Integer> al1 = new ArrayList<>(n);
		ArrayList<Integer> al2 = new ArrayList<>(n);
		//ArrayList<Integer> al3 = new ArrayList<>(n);
		
		for(int i = 0;i<n;i++) {
			al1.add(sc.nextInt());
		}
		for(int i = 0;i<n;i++) {
			al2.add(sc.nextInt());
		}
		for(int i = 0;i<n;i++) {
			al.add(sc.nextInt()+al1.get(i)+al2.get(i));
		}
		Collections.sort(al);
		int query = sc.nextInt();
		LinkedList<Integer> l = new LinkedList<>();
		for(int i = 0;i<n; i++) {
			l.add(al.get(i));
		}
		int size = l.size();
		while(query>0) {
			
			int k = sc.nextInt();
			if(k>size) {
				System.out.println(-1);
			}else {
				System.out.println(l.get(k-1));
				l.remove(k);
				size--;
			}
			query--;
		}
	}
}
