package dataStructures;

class BinaryTreeNode{
	int key;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode p;

	public BinaryTreeNode(int key) {
		this.key  = key;
		left = right = p = null;
	}
	
	public BinaryTreeNode() {
								
	}
}

public class BinarySearchTree {
	
	BinaryTreeNode root;
	BinaryTreeNode nullNode = new BinaryTreeNode();
	
	public BinarySearchTree(BinaryTreeNode root) {
		root.p = nullNode;
	}
	
	void inorderTreeWalk(BinaryTreeNode t) {
		if (t != nullNode) {
			inorderTreeWalk(t.left);
			System.out.println(t.key);
			inorderTreeWalk(t.right);
		}
	}
	
	BinaryTreeNode treeSearch(BinaryTreeNode t, int key) {
		if (t == nullNode || t.key == key) {
			return t;
		}
		if (t.key < key) {
			return treeSearch(t.left, key);
		}else {
			return treeSearch(t.right, key);
		}
	}
	
	BinaryTreeNode iterativeTreeSearch(BinaryTreeNode t, int key) {
		while (t != nullNode || key != t.key) {
			if (key < t.key) {
				t = t.left;
			}else {
				t = t.right;
			}
		}
		return t;
	}
	
	BinaryTreeNode treeMinimum(BinaryTreeNode t) {
		while (t.left != nullNode) {
			t = t.left;
		}
		return t;
	}
	
	BinaryTreeNode treeMaximum(BinaryTreeNode t) {
		while (t.right != nullNode) {
			t = t.right;
		}
		return t;
	}
	
	/*BinaryTreeNode treeSuccessor(BinaryTreeNode t) {
		
	}*/
	
	void treeInsert(BinarySearchTree T, BinaryTreeNode z) {
		BinaryTreeNode y = nullNode;
		BinaryTreeNode x = T.root;
		while (x != nullNode) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			}else {
				x = x.right;
			}
		}
		z.p = y;
		if (y == nullNode) {
			T.root = z;
		}
		if (z.key < y.key) {
			y.left = z;
		}else {
			y.right = z;
		}
	}
	
	void transplant(BinarySearchTree T, BinaryTreeNode u, BinaryTreeNode v) {
		if (u.p == nullNode) {
			T.root = v;
		}else if (u.p.left == u) {
			u.p.left = v;
		}else {
			u.p.right = v;
		}
		if (v != nullNode) {
			v.p = u.p;
		}
	}
	
	void treeDelete(BinarySearchTree T, BinaryTreeNode z) {
		if (z.left == nullNode) {
			transplant(T, z, z.right);
		}else if(z.right == nullNode) {
			transplant(T, z, z.left);
		}else {
			BinaryTreeNode y = treeMinimum(z.right);
			if (y.p != z) {
				transplant(T, y, y.right);
				y.right = z.right;
				y.right.p = y;
			}
			transplant(T, z, y);
			y.left = z.left;
			y.left.p = y;
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode node = new BinaryTreeNode(5);
		BinarySearchTree tree = new BinarySearchTree(node);
		tree.treeInsert(tree, new BinaryTreeNode(1));
		tree.treeInsert(tree, new BinaryTreeNode(1));
	}
	
}
