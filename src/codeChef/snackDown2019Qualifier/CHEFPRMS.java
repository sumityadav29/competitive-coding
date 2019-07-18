package codeChef.snackDown2019Qualifier;

import java.util.Arrays;
import java.util.Scanner;

public class CHEFPRMS {
	
	static boolean[] sieve() {
		int x = 200;
		boolean[] arr = new boolean[x];
		for(int i=2;i<Math.sqrt(x);i++){
			for(int j=i*i;j<x;j=j+i) {
				if(arr[j]==false) {
					arr[j]=true;
				}
			}
		}
		return arr;
	}
	
	static int[] savePrimes(boolean[] arr) {
		arr[0] = true;
		arr[1] = true;
		int primes[] = new int[46];
		int index = 0;
		for(int i=0; i<200;i++) {
			if(arr[i] == false) {
				primes[index] = i;
				index++;
			}
		}
		//System.out.println(Arrays.toString(primes));
		return primes;
	}
	
	static boolean isSemiPrime(int n, int primes[]) {
		for(int i=0; i<primes.length;i++) {
			if(n%primes[i]==0) {
				if(Arrays.binarySearch(primes, n/primes[i])>=0) {
					//System.out.println(primes[i]);
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		boolean[] sieve = sieve();
		int primes[] = savePrimes(sieve);
		
		while(t>0) {
			int n = sc.nextInt();
			boolean flag = true;
			for(int i = 6 ; i <= n/2 ; i++) {
				int num1 = i;
				int num2 = n-i;
				if(isSemiPrime(num1,primes) && isSemiPrime(num2,primes)) {
					//System.out.println(num1+" "+num2);
					System.out.println("YES");
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("NO");
			}
			t--;
		}
	}
}
