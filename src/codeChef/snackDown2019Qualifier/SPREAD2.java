package codeChef.snackDown2019Qualifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SPREAD2 {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(r.readLine());
		
		while(t>0) {
			
			int n = Integer.parseInt(r.readLine());
			ArrayList<Integer> arr = new ArrayList<>(n);
			String s = r.readLine();
			//System.out.println(s);
			StringTokenizer st = new StringTokenizer(s);
			while(st.hasMoreTokens()) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			int know = 0;
			int knowSum = arr.get(0);
			int days = 0;
			while(true) {
				days++;
				if(knowSum>=(n-know-1)) {
					break;
				}
				int end = (know+knowSum<n)?know+knowSum:n-1;
				for(int i = know+1;i<end;i++) {
					knowSum+=arr.get(i);
				}
				know = know+knowSum;
			}
			System.out.println(days);
			t--;
		}
	}
}
