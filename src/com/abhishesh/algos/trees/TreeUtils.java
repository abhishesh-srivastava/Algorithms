package com.abhishesh.algos.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {
	private static int leftMaxLevel = -1;
	private static int rightMaxLevel = -1;

	/**
	 * inorder traversal of binary tree with root node as root
	 * 
	 */
	public static void inorder(TreeNode root) {
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(" " + root.data);
		inorder(root.right);
	}
	
	/**
	 * PreOrder traversal of binary tree
	 */
	public static void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(" " + root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	/**
	 * PostOrder traversal of binary tree
	 */
	public static void postOrder(TreeNode root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(" " + root.data);
	}
	
	/**
	 * print left view of a binary tree
	 */
	public static void leftView(TreeNode root) {
		leftMaxLevel = -1;
		leftViewUtil(root, 0);
	}
	
	private static void leftViewUtil(TreeNode root,int level) {
		if(root==null)
			return;
		if(leftMaxLevel < level) {
			System.out.print(" " + root.data);
			leftMaxLevel = level;
		}
		leftViewUtil(root.left, level+1);
		leftViewUtil(root.right, level+1);
	}
	
	/**
	 * print right view of a binary tree
	 */
	public static void rightView(TreeNode root) {
		rightMaxLevel = -1;
		rightViewUtil(root, 0);
	}
	
	private static void rightViewUtil(TreeNode root,int level) {
		if(root==null)
			return;
		if(rightMaxLevel < level) {
			System.out.print(" " + root.data);
			rightMaxLevel = level;
		}
		rightViewUtil(root.right, level+1);
		rightViewUtil(root.left, level+1);
	}
	
	/**
	 * level order traversal of binary tree, implemented using queue
	 */
	public static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		if(root == null)
			return;
		TreeNode temp = root;
		while(temp!=null || !queue.isEmpty()) {
			System.out.print(temp.data + " ");
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
			if(queue.isEmpty())
				break;
			temp = queue.remove();
		}
		System.out.println();
	}
	
	/**
	 * prints all root to leaf paths for a binary tree
	 */
	public static void printAllRootToLeafPath(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		printRootToLeafUtil(root,list);
		
	}
	
	private static void printRootToLeafUtil(TreeNode root, List<TreeNode> list) {
		if(root == null)
			return;
		list.add(root);
		if(root.left == null && root.right == null){
			System.out.println(list);
			return;
		}
		printRootToLeafUtil(root.left, new ArrayList<>(list));
		printRootToLeafUtil(root.right, new ArrayList<>(list));
		
	}

	/**
	 * converts to mirror image of binary tree
	 * (mirror is placed vertically on right side of tree)
	 */
	public static TreeNode converToMirrorImage(TreeNode root){
		if(root!=null){
			converToMirrorImage(root.left);
			converToMirrorImage(root.right);
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}

	/**
	 * Check whether binary tree p and q are identical to each other
	 */
	public static boolean areIdentical(TreeNode p, TreeNode q) {
		if(p==null && q==null)
			return true;
		if(p==null || q==null)
			return false;
		return (p.data==q.data) && areIdentical(p.left, q.left) && areIdentical(p.right, q.right);
	}
	
	/**
	 * Vertical sum of a binary tree
	 */
	private static int []arr;
	public static int[] verticalSum(TreeNode root) {
		int leftDistance = findLeftMax(root);
		int rightDistance = findRightDepth(root);
		int size = leftDistance + rightDistance -1;
		arr = new int[size];
		verticalSumUtil(root,leftDistance);
		return arr;
	}
	
	private static void verticalSumUtil(TreeNode root, int index) {
		if(root==null)
			return;
		arr[index-1]+=root.data;
		verticalSumUtil(root.left,index-1);
		verticalSumUtil(root.right,index+1);
	}

	private static int findRightDepth(TreeNode root) {
		if(root == null)
			return 0;
		return 1+findRightDepth(root.right);
	}

	private static int findLeftMax(TreeNode root) {
		if(root == null)
			return 0;
		return 1+findLeftMax(root.left);
	}

	// helper method to build a dummy binary tree
	public static TreeNode buildDummyTree() {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		p.left.left = new TreeNode(4);
		p.left.right = new TreeNode(5);
		p.right.left = new TreeNode(6);
		return p;
	}
}
