package codeChef;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Scanner;
class PairComparator implements Comparator<Pair>{

	@Override
	public int compare(Pair p1, Pair p2) {
		if(p1.first>p2.first) {
			return -1;
		}else if(p1.first==p2.first) {
			return 0;
		}
		return 1;
	}
	
}

class Pair {
	long first;
	int second;
	Pair(long first,int second){
		this.first = first;
		this.second = second;
	}
}

public class HMAPPY {
	
	static int partition(long arr[], int low, int high, int arr2[]) 
    { 
        long pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                long temp = arr[i];
                int temp2 = arr2[i];
                
                arr[i] = arr[j]; 
                arr2[i] = arr2[j];
                
                arr[j] = temp; 
                arr2[j] = temp2;
               
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        long temp = arr[i+1];
        int temp2 = arr2[i+1];
        
        arr[i+1] = arr[high]; 
        arr2[i+1] = arr2[high];
        
        arr[high] = temp; 
        arr2[high] = temp2;
        
  
        return i+1; 
    } 

    static void sort(long arr[], int low, int high,int arr2[]) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high,arr2); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1,arr2); 
            sort(arr, pi+1, high,arr2); 
        } 
    } 
    
    int secondLargest(long arr[],int largest) {
    	long max = Integer.MIN_VALUE;
    	int maxi = 0;
    	for(int i = 0; i<arr.length ;i++) {
    		if(i!=largest) {
    			if(arr[i]<=arr[largest] && arr[i]>=max) {
        			max = arr[i];
        			maxi = i;
        		}
    		}
    	}
    	//System.out.println(arr[largest]+" "+largest+" "+arr[maxi]+" "+maxi);
    	return maxi;
    }
    
    static void shift(long arr1[],int arr2[]) {
    	long temp = arr1[arr1.length-1];
    	int temp2 = arr2[arr2.length-1];
    	int i =arr1.length-2;
    	while(true) {
    		if(i>=0 && arr1[i]>temp) {
    			arr1[i+1]=arr1[i];
    			arr2[i+1]=arr2[i];
    		}else {
    			break;
    		}
    		i--;
    	}
    	arr1[i+1]=temp;
    	arr2[i+1]=temp2;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long m = sc.nextLong();
		int A[] = new int[n];
		//int B[] = new int[n];
		//long M[] = new long[n];
		PriorityQueue<Pair> q = new PriorityQueue<>(n,new PairComparator());
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			A[i] = sc.nextInt();
			sum += A[i];
		}
		for(int i=0; i<n; i++) {
			int B = sc.nextInt();
			Pair newNode = new Pair(A[i]*B, B);
			q.add(newNode);
		}
		A = null;
// First Approach--------------------->>>>>>>>>>>>>>>>>>>>>>>>>>
//		if(m>=sum) {
//			System.out.println(0);
//		}else {
//			sort(B,0,n-1,A,M);
//			long sup = sum-m;
//			while(sup>0) {
//				for(int i =0; i<n && sup>0;i++) {
//					if(A[i]!=0) {
//						A[i]--;
//						//System.out.print(A[i]);
//						sup--;
//					}
//				}
//				//System.out.println();
//			}
//			long ans = Integer.MIN_VALUE;
//			int ansi = 0;
//			for(int i =0;i<n;i++) {
//				if(A[i]!=0) {
//					long tempans = M[i]-(A[i]*B[i]);
//					if(tempans>ans) {
//						ans = tempans;
//						ansi = i;
//					}
//				}
//			}
//			System.out.println(M[ansi]-(A[ansi]*B[ansi]));
//		}
		
		
// Second Approach -------------------->>>>>>>>>>>>>>>>>>>>>>>>		
		/*if(m>=sum) {
			System.out.println(0);
		}else {
			long num = 0;
			sort(M,0,n-1,B);
			int largest = n-1;
			int slargest = n-2;
			while(m>0) {
				
				long red = M[largest]-M[slargest];
				
				red = red + B[largest] - red%B[largest];
				
				num = red/B[largest];
				if(m>num) {
					m = m-num;
					M[largest] = M[largest]-(B[largest]*num);
				}else {
					M[largest] = M[largest]-(B[largest]*m);
					m = 0;
				}
				largest = slargest;
				slargest = secondLargest(M, largest);
				//System.out.println(Arrays.toString(M));
			}
			Arrays.sort(M);
			System.out.println(M[n-1]);
		}*/
// Third Approach--------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		/*if(m>=sum) {
			System.out.println(0);
		}else {
			long num = 0;
			sort(M,0,n-1,B);
			while(m>0) {
				long red = M[n-1]-M[n-2];
				red = red+B[n-1]-(red%B[n-1]);
				num = red/B[n-1];
				if(m>num) {
					M[n-1] = M[n-1]-(B[n-1]*num);
					m = m-num;
				}else {
					M[n-1] = M[n-1]-(B[n-1]*(int)m);
					m=0;
				}
				shift(M,B);
				//System.out.println(Arrays.toString(M));
			}
			System.out.println(M[n-1]);
		}*/
		
		if(m>=sum) {
			System.out.println(0);
		}else {
			while(m>0) {
				Pair p1 = q.poll();
				if(p1.first==0) {
					q.add(p1);
					m=0;
					break;
				}
				Pair p2 = q.peek();
				long temp;
				if(p1.first!=p2.first) {
					temp = ((p1.first-p2.first)/p1.second)+1;
				}else {
					/*Pair tempPair;
					if(p1.second<p2.second) {
						Pair newTemp = q.poll();
						q.add(p1);
						p1=newTemp;
					}*/
					Pair tempPair = new Pair(p1.first-Math.max(p1.second, p2.second), Math.max(p1.second, p2.second));
					q.add(tempPair);
					m--;
					continue;
				}
				if(m<temp) {
					temp = m;
				}
				p1.first = p1.first-temp*p1.second;
				m = m-temp;
				q.add(p1);
			}
			System.out.println(q.peek().first);
		}
		
	}
}
