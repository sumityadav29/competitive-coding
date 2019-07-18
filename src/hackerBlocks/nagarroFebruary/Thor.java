package hackerBlocks.nagarroFebruary;

import java.util.Scanner;

public class Thor {
	
	static void build(int node, int start, int end, long tree[],long A[])
	{
	    if(start == end)
	    {
	        // Leaf node will have a single element
	        tree[node] = A[start];
	    }
	    else
	    {
	        int mid = (start + end) / 2;
	        // Recurse on the left child
	        build(2*node, start, mid, tree, A);
	        // Recurse on the right child
	        build(2*node+1, mid+1, end, tree, A);
	        // Internal node will have the sum of both of its children
	        tree[node] = Math.min(tree[2*node] , tree[2*node+1]);
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in );
		int n = sc.nextInt();
		long m = sc.nextLong();
		long tree[] = new long[2*n];
		long arr[] = new long[n];
		for (int i = 0; i< n; i++) {
			arr[i] = sc.nextLong();
		}
		build(0, 0, n-1, tree, arr);
		
	}
}
