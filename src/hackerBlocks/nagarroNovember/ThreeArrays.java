package hackerBlocks.nagarroNovember;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeArrays {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int arr1[] = new int[n1];
		int arr2[] = new int[n2];
		int arr3[] = new int[n3];
		for (int i = 0;i <n1; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0;i <n2; i++) {
			arr2[i] = sc.nextInt();
		}
		for (int i = 0;i <n3; i++) {
			arr3[i] = sc.nextInt();
		}
		int min = Math.max(Math.max(arr1[0], arr2[0]),arr3[0]) - Math.max(Math.max(arr2[0], arr1[0]),arr3[0]);
		for (int i = 0; i< n1;i++) {
			int temp = arr1[i];
			int temp2 = Arrays.binarySearch(arr2, temp);
			int temp3 = Arrays.binarySearch(arr3, temp);
			
			int tempAns = Math.max(Math.max(temp, arr2[temp2]),arr3[temp3]) - Math.min(Math.min(arr2[temp2], temp),arr3[temp3]) ;
			if (tempAns < min) {
				min = tempAns;
			}
		}
	}
}
