package codeChef.novemberLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**@author sumityadav
/**structure of circular linked list node**/
class llNode {
	int num;
	llNode next;
	llNode prev;		
	llNode(int num){
		this.num = num;
		this.next = null;
		this.prev = null;
	}
}
/**----------------------------**/

public class HMAPPY1 {
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int q = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		/**Creating a Linked List of number of contiguous ones and zeros for rotation queries**/
		llNode ptr = null;
		if (arr[0] == 1) {
			ptr =  new llNode(1);
		}else {
			ptr = new llNode(-1);
		}
		llNode head = ptr;
		for (int i = 1; i < n; i++) {
			if (arr[i] == arr[i-1]) {
				if (arr[i] == 1) {
					ptr.num++;
				}else {
					ptr.num--;
				}
			}else {
				ptr.next = new llNode(arr[i] == 0 ?-1:1);
				ptr.next.prev = ptr;
				ptr = ptr.next;
			}
		}
		llNode tail = ptr;
		tail.next = head;
		head.prev = tail;
		/**----------------------------------**/
		
		/**Creating bst for '?' query**/
		BinarySearchTree tree = new BinarySearchTree();
		ptr = head;
		do {
			tree.insert(ptr.num);
			ptr = ptr.next;
		}while(ptr != head);
		/**---------------------------**/
		
		String str = sc.next();
		int i = 0;
		while (i < q) {
			if (str.charAt(i) == '!') {
				if (head != tail) {
					if (head.num > 0 && tail.num > 0) {
						if (tail.num == 1) {
							tail = tail.prev;
							head.next = tail;
							tail.next = head;
							tree.deleteKey(head.num);
							head.num++;
							tree.insert(head.num);
							tree.deleteKey(1);
						}else {
							tree.deleteKey(tail.num);
							tail.num--;
							tree.insert(tail.num);
							tree.deleteKey(head.num);
							head.num++;
							tree.insert(head.num);
						}
						
					}else if (head.num > 0 && tail.num < 0) {
						if (tail.num == -1) {
							head = tail;
							tail = tail.prev;
						}else {
							llNode newNode = new llNode(-1);
							newNode.next = head;
							newNode.prev = tail;
							tail.next = newNode;
							head.prev = newNode;
							head = newNode;
							tree.deleteKey(tail.num);
							tail.num++;
							tree.insert(tail.num);
							tree.insert(newNode.num);
						}
					}else if (head.num < 0 && tail.num < 0) {
						if (tail.num == -1) {
							tail = tail.prev;
							tail.next = head;
							head.prev = tail;
							tree.deleteKey(head.num);
							head.num--;
							tree.insert(head.num);
						}else {
							tree.deleteKey(tail.num);
							tail.num++;
							tree.insert(tail.num);
							tree.deleteKey(head.num);
							head.num--;
							tree.insert(head.num);
						}
					}else if (head.num < 0 && tail.num > 0) {
						if (tail.num == 1) {
							head = tail;
							tail = tail.prev;
						}else {
							llNode newNode = new llNode(1);
							newNode.next = head;
							newNode.prev = tail;
							head.prev = newNode;
							tail.next = newNode;
							tree.deleteKey(tail.num);
							tail.num--;
							tree.insert(tail.num);
							head = newNode;
							tree.insert(newNode.num);
						}
					}
				}
				
			}else if (str.charAt(i) == '?') {
				int max = tree.maxValue(tree.root);
				if (max >= k) {
					max = k;
				}else if (max < 0) {
					max = 0;
				}
				System.out.println(max);
			}
			i++;
		}	
	}
	
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
	
}

/**BST structure augmented to store duplicate keys via "frequency" field**/
class BinarySearchTree 
{ 
	/* Class containing left and right child of current node and key value*/
	class Node 
	{ 
		int key; 
		int frequency = 0;
		Node left, right; 

		public Node(int item) 
		{ 
			key = item; 
			frequency = 1;
			left = right = null; 
		} 
	} 

	// Root of BST 
	Node root; 

	// Constructor 
	BinarySearchTree() 
	{ 
		root = null; 
	} 

	// This method mainly calls deleteRec() 
	void deleteKey(int key) 
	{ 
		root = deleteRec(root, key); 
	} 

	/* A recursive function to insert a new key in BST */
	Node deleteRec(Node root, int key) 
	{ 
		/* Base Case: If the tree is empty */
		if (root == null) return root; 

		/* Otherwise, recur down the tree */
		if (key < root.key) 
			root.left = deleteRec(root.left, key); 
		else if (key > root.key) 
			root.right = deleteRec(root.right, key); 

		// if key is same as root's key, then This is the node 
		// to be deleted 
		else
		{
		    if (root.frequency > 1){
		        root.frequency--;
		        return root;
		    }
			// node with only one child or no child 
			if (root.left == null) 
				return root.right; 
			else if (root.right == null) 
				return root.left; 

			// node with two children: Get the inorder successor (smallest 
			// in the right subtree) 
			root.key = minValue(root.right); 

			// Delete the inorder successor 
			root.right = deleteRec(root.right, root.key); 
		} 

		return root; 
	} 

	int minValue(Node root) 
	{ 
		int minv = root.key; 
		while (root.left != null) 
		{ 
			minv = root.left.key; 
			root = root.left; 
		} 
		return minv; 
	} 
	
	int maxValue(Node root) 
	{ 
		int minv = root.key; 
		while (root.right != null) 
		{ 
			minv = root.right.key; 
			root = root.right; 
		} 
		return minv; 
	}

	// This method mainly calls insertRec() 
	void insert(int key) 
	{ 
		root = insertRec(root, key); 
	} 

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) 
	{ 

		/* If the tree is empty, return a new node */
		if (root == null) 
		{ 
			root = new Node(key); 
			return root; 
		} 
		
		if (root.key == key){
		    root.frequency++;
		    return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key) 
			root.left = insertRec(root.left, key); 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	} 

	// This method mainly calls InorderRec() 
	void inorder() 
	{ 
		inorderRec(root); 
	} 

	// A utility function to do inorder traversal of BST 
	void inorderRec(Node root) 
	{ 
		if (root != null) 
		{ 
			inorderRec(root.left); 
			System.out.print(root.key + " "); 
			inorderRec(root.right); 
		} 
	} 
} 
