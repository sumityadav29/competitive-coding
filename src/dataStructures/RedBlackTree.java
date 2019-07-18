package dataStructures;

enum Color{
	RED,BLACK;
}

class RedBlackTreeNode extends BinaryTreeNode {
	Color color;
	RedBlackTreeNode left;
	RedBlackTreeNode right;
	RedBlackTreeNode p;
	public RedBlackTreeNode(int key) {
		super(key);
		this.color = Color.RED;
	}
	public RedBlackTreeNode() {
		
	}
}

public class RedBlackTree extends BinarySearchTree {
	
	RedBlackTreeNode root;
	RedBlackTreeNode nullNode = new RedBlackTreeNode();
	
	public RedBlackTree(RedBlackTreeNode root) {
		super(root);
	}
	
	void leftRotate(RedBlackTree T, RedBlackTreeNode x) {
		RedBlackTreeNode y = x.right;
		x.right = y.left;
		if(y.left != nullNode) {
			y.left.p = x;
		}
		y.p = x.p;
		if (x.p == nullNode) {
			T.root = y;
		}else if(x.p.left == x) {
			x.p.left = y;
		}else {
			x.p.right = y;
		}
		y.left = x;
		x.p = y;
	}
	
	void rightRotate(RedBlackTree T, RedBlackTreeNode y) {
		RedBlackTreeNode x = y.left;
		y.left = x.right;
		if(x.right != nullNode) {
			x.right.p = y;
		}
		x.p = y.p;
		if (y.p == nullNode) {
			T.root = x;
		}else if (y == y.p.left) {
			y.p.left = x;
		}else {
			y.p.right = x;
		}
		x.right = y;
		y.p = x;
	}
	
	void rbInsert(RedBlackTree T, RedBlackTreeNode z) {
		RedBlackTreeNode y = nullNode;
		RedBlackTreeNode x = T.root;
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
		z.left = nullNode;
		z.right = nullNode;
		z.color = Color.RED;
		rbInsertFixup(T, z, y);
	}

	private void rbInsertFixup(RedBlackTree T, RedBlackTreeNode z, RedBlackTreeNode y) {
		while (z.p.color == Color.RED) {
			if (z.p == z.p.p.left) {
				y = z.p.p.right;
				if (y.color == Color.RED) {
					z.p.color = Color.BLACK;
					y.color = Color.BLACK;
					z.p.p.color = Color.RED;
					z = z.p.p;
				}else if (z == z.p.right) {
					z = z.p;
					leftRotate(T, z);
				}else {
					z.p.color = Color.BLACK;
					z.p.p.color = Color.RED;
					rightRotate(T, z.p.p);
				}
			}else {
				y = z.p.p.left;
				if (y.color == Color.RED) {
					z.p.color = Color.BLACK;
					y.color = Color.BLACK;
					z.p.p.color = Color.RED;
					z = z.p.p;
				}else if (z == z.p.left) {
					z = z.p;
					leftRotate(T, z);
				}else {
					z.p.color = Color.BLACK;
					z.p.p.color = Color.RED;
					rightRotate(T, z.p.p);
				}
			}
		}
		T.root.color = Color.BLACK;
	}
	
}
