import java.util.*;
import java.io.*;


//7
//3
//5
//2
//1
//4
//6
//7

public class BinarySearchTree {
	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	//Editor Solution
//	public static int getHeight(Node root){
//	    if (root == null){
//	        return -1;
//	    }
//	    else{
//	        return 1 + Math.max( getHeight(root.left), getHeight(root.right) );
//	    }
//	}
	
	public static int getHeight(Node root) {
		if (root == null) {
			return 1;
		}
		int rightH = 0;
		int leftH = 0;
		if (root.left != null) {
			leftH = getHeight(root.left) + 1;
		}
		if (root.right != null) {
			rightH = getHeight(root.right) + 1;
		}
		if (leftH > rightH) {
			return leftH;
		} else {
			return rightH;
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		int height = getHeight(root);
		System.out.println(height);
	}
}
