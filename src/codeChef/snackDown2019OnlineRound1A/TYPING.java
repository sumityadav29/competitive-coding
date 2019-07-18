package codeChef.snackDown2019OnlineRound1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TYPING {
	
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
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			HashMap<String, Integer> map = new HashMap<>();
			int time = 0;
			while(n-- > 0) {
				String s = sc.next();
				if (map.containsKey(s)) {
					//System.out.println(map.get(s)/2 + " ");
					time = time + (map.get(s)/2);
					//System.out.println(time);
				}else {
					int wordTime = 2;
					for(int i = 1; i<s.length(); i++) {
						/*if (i == 0) {
							wordTime += 0.2;
						}*/
						char lastChar = s.charAt(i-1);
						if((lastChar == 'd' || lastChar == 'f') && (s.charAt(i) == 'd' ||s.charAt(i) == 'f')) {
							wordTime += 4;
						}else if ((lastChar == 'j' || lastChar == 'k') && (s.charAt(i) == 'j' ||s.charAt(i) == 'k')) {
							wordTime += 4;
						}else {
							wordTime += 2;
						}
					}
					//System.out.println(wordTime+" ");
					time += wordTime;
					//System.out.println(time);
					map.put(s, wordTime);
				}
			}
			System.out.println(time);
		}
		
	}
	
}
