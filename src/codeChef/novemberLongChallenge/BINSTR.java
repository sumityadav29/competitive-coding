package codeChef.novemberLongChallenge;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedHashMap;

class TrieNode{
	boolean arr[];;
	boolean isEndOfWord;
	int index;
	TrieNode one;
	TrieNode zero;
	public TrieNode() {
		this.arr = new boolean[2];
		this.one = null;
		this.zero = null;
	}
}

public class BINSTR {
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	
	static char xorChar(char c1, char c2) {
		if (c1 == '1' && c2 == '0') {
			return '1';
		}else if (c1 == '0' && c2 == '1') {
			return '1';
		}else {
			return '0';
		}
	}
	
	static String xor(String str1, String str2) {
		int len = str1.length();
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < len; i++) {
			s.append(xorChar(str1.charAt(i), str2.charAt(i)));
		}
		return s.toString();
	}
	
	static boolean compare(String str1, String str2, int len) {
		for (int i = 0; i < len; i++) {
			if (str1.charAt(i) == '1' && str2.charAt(i) == '0') {
				return true;
			}else if (str1.charAt(i) == '0' && str2.charAt(i) == '1') {
				return false;
			}
		}
		return false;
	}
	
	static void printTrie(TrieNode ptr, int level) {                                        
		System.out.println(Arrays.toString(ptr.arr));
		try {
			printTrie(ptr.zero, level+1);
		}catch(Exception e) {
			
		}
		try {
			printTrie(ptr.one, level+1);
		}catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		FastReader sc =  new FastReader();
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		String arr[] = new String[n];
		
		for (int i = 0 ; i < n; i++) {
			arr[i] = sc.next();
		}
		
		final int len = arr[0].length();
		
		while (q-- > 0) {
			int l = sc.nextInt()-1;
			int r = sc.nextInt()-1;
			
			TrieNode root = new TrieNode();
			
			TrieNode ptr = root;
			for (int i = l; i<=r; i++) {
				int j = 0;
				ptr = root;
				while (j < arr[i].length()) {
					if (arr[i].charAt(j) == '1') {
						
						if (!ptr.arr[1]) {
							ptr.one = new TrieNode();
							ptr.arr[1] = true;
						}
						if (j == arr[i].length()-1 && !ptr.isEndOfWord) {
							ptr.isEndOfWord = true;
							ptr.index = i;
						}
						ptr = ptr.one;
						
					}else {
						
						if (!ptr.arr[0]) {
							ptr.zero = new TrieNode();
							ptr.arr[0] = true;
						}
						if (j == arr[i].length()-1 && !ptr.isEndOfWord) {
							ptr.isEndOfWord = true;
							ptr.index = i;
						}
						ptr = ptr.zero;
						
					}
					j++;
				}
			}
			
			printTrie(root, 0);
			
			String x = sc.next();
			ptr = root ;
			int index = 0;
			for (int i = 0; i<x.length(); i++) {
				System.out.println(x.charAt(i));
				if (x.charAt(i) == '1') {
					try {
						ptr = ptr.zero;
					}catch(Exception e) {
						ptr = ptr.one;
					}
				}else {
					try {
						ptr = ptr.one;
					}catch(Exception e) {
						ptr = ptr.zero;
					}
				}
				index = i == x.length()-1 ? ptr.index:index;
			}
			
			System.out.println(index+1);
			
		}
		
	}
}
