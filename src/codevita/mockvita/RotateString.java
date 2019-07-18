package codevita.mockvita;

import java.util.Arrays;
import java.util.Scanner;

public class RotateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int q = sc.nextInt();

        int index = 0;
        StringBuilder fcs = new StringBuilder();

        while (q-- > 0){
            char d = sc.next().charAt(0);
            int r = sc.nextInt();
            index = simulateRotation(str.length(), d, r, index);
            fcs.append(str.charAt(index));
        }

        char[] fcStr = fcs.toString().toCharArray();
        Arrays.sort(fcStr);

        int subStrlen = fcStr.length - 1;
        for (int i = 0 ; i < str.length() - subStrlen ; i ++){
            char[] anagram = str.substring(i, i+subStrlen).toCharArray();
            Arrays.sort(anagram);
            if(Arrays.equals(fcStr, anagram)){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    public static int simulateRotation(int strLen, char d, int r, int index){
        while (r-- > 0) {
        	if (d == 'L') {
        		index++;
        	}else {
        		index--;
        	}
        }
        while (index < 0 ) {
    		index = index + strLen;
    	}
        index = index % strLen;
        return index;
    }
}
