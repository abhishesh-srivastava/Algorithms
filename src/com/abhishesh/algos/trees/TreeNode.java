package com.abhishesh.algos.trees;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public String toString() {
		return " " + data;
	}
}
