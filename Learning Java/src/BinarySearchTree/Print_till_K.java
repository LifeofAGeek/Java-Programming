package BinarySearchTree;

/*
 * Given a tree and a node of tree, print all nodes which are at distance k from the given node.

Input Format
Enter the number of nodes N and add N more numbers to the BST. Then enter the target number and value of k.

Constraints
None

Output Format
Display all the nodes which are at a distance k in a new line

Sample Input
4
1
2
3
4
4
2
Sample Output
2
 */

import java.util.Scanner;

public class Print_till_K {

	private static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private static Node root = null;
	private static int size = 0;

	public static int size() {
		return size;
	}

	public static boolean isEmpty() {
		return size() == 0;
	}

	public static void add(int data) {
		add(data, root);
	}

	private static void add(int data, Node node) {
		if (isEmpty()) {
			Node n = new Node(data, null, null);
			size++;
			root = n;
			return;
		} else {
			if (data > node.data && node.right == null) {
				Node n = new Node(data, null, null);
				size++;
				node.right = n;
			} else if (data < node.data && node.left == null) {
				Node n = new Node(data, null, null);
				size++;
				node.left = n;
			} else if (data > node.data) {
				add(data, node.right);
			} else if (data < node.data) {
				add(data, node.left);
			}
		}
	}

	public static void display() {
		display(root);
	}

	private static void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + " => ");
		} else {
			System.out.print("END => ");
		}
		System.out.print(node.data);
		if (node.right != null) {
			System.out.print(" <= " + node.right.data);
		} else {
			System.out.print(" <= END");
		}
		System.out.println();
		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}
	}

	public static void printKFar(int tar, int k) {
		printKFar(root, tar, k);
	}

	private static int printKFar(Node node, int tar, int k) {
		if (node == null)
			return -1;

		if (node.data == tar) {
			printKDown(node, k);
			return 0;
		}

		int ld = printKFar(node.left, tar, k);

		if (ld != -1) {
			if (ld + 1 == k)
				System.out.println(node.data);
			else
				printKDown(node.right, k - 2 - ld);
			return ld + 1;
		}

		int rd = printKFar(node.right, tar, k);

		if (rd != -1) {
			if (rd + 1 == k)
				System.out.println(node.data);
			else
				printKDown(node.left, k - 2 - rd);
			return rd + 1;
		}
		return -1;
	}

	private static void printKDown(Node node, int k) {
		if (node == null || k < 0)
			return;
		if (k == 0) {
			System.out.println(node.data);
			return;
		}
		printKDown(node.left, k - 1);
		printKDown(node.right, k - 1);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			add(s.nextInt());
		}
		int tar = s.nextInt();
		int k = s.nextInt();
		printKFar(tar, k);
	}

}
