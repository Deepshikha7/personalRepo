package com.personal.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Deepshikha
 * This is linked list implementation of binary tree.
 * Following operations are defined so far - 
 * 1. Preorder through recursion
 * 2. Postorder through recursion
 * 3. Inorder through recursion
 * 4. Leverorder through queue 
 * 
 * TODO: Following operations remain
 * 1. Preorder through iteration
 * 2. ...
 */
public class BinaryTree {
	
	TreeNode root;
	BinaryTree(){
		this.root = null;
	}
	
	void printTreePreOrder(TreeNode root) {
		if(root == null)
			return ;
		else {
			System.out.print(root.data + "  ");
			printTreePreOrder(root.left);
			printTreePreOrder(root.right);
		}
	}
	
	void printTreePostOrder(TreeNode root) {
		if(root == null)
			return;
		else {
			printTreePostOrder(root.left);
			printTreePostOrder(root.right);
			System.out.print(root.data + "  ");
		}
	}
	
	void printTreeInorder(TreeNode root) {
		if(root == null)
			return;
		else {
			printTreeInorder(root.left);
			System.out.print(root.data +"  ");
			printTreeInorder(root.right);
		}
	}
	 	
	void printTreeLevelOrder() {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode t = q.poll();
			System.out.print(t.data + "  ");
			if(t.left != null)
				q.add(t.left);
			if(t.right != null)
				q.add(t.right);
		}
	}
	
	
	void searchNode(int data) {
		Queue<TreeNode> t = new LinkedList<TreeNode>();
		t.add(root);
		
		while(!t.isEmpty()) {
			TreeNode n = t.poll();
			if(n != null && n.data == data) {
				System.out.println("ELement found = "+ data);
				return;
				}
			
			if(n != null && n.left != null)
				t.add(n.left);
			
			if(n != null && n.right != null)
				t.add(n.right);
			
		}
		System.out.println("Element not found = "+ data);
		
	}
	
	void insertNode(int data) {
		TreeNode t = new TreeNode(data);
		if(root == null) {
			root = t;
			System.out.println("Element added is the root ");
			return;
		}
		else {
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			
			while(!q.isEmpty()) {
				TreeNode node = q.poll();
				if(node != null) {
					if(node.left == null) {
						node.left = t;
						System.out.println(t.data+" added to left of : "+node.data);
						return;
					}
					if(node.right == null) {
						node.right = t;
						System.out.println(t.data +" added to right of : "+node.data);
						return;
					}
					
					if(node.left != null)
						q.add(node.left);
					
					if(node.right != null) 
						q.add(node.right);
				}
			}
		}
	}
	
	void deleteNode(int data) {
		
		//get the last node
		
		TreeNode lastNode = getLastNode();
		if(null == lastNode) {
			System.out.println("Empty Tree");
			return;
		}
		
		//replace the last node data with the data to be deleted
		
		TreeNode nodeToBeDeleted = getNodeToBeDeleted(data);
		if(nodeToBeDeleted == null) {
			System.out.println("Data is not present in the tree");
			return;
		}
		
		//set data of node to be deleted to the last node's data;
		nodeToBeDeleted.data = lastNode.data;
	}
	
	TreeNode getLastNode() {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode t = null;
		while(!q.isEmpty()) {
			t = q.poll();
			if(t != null && t.left != null)
				q.add(t.left);
			if(t != null && t.right != null)
				q.add(t.right);
		}
		return t;
	}
	
	TreeNode getNodeToBeDeleted(int data) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode t = null;
		while(!q.isEmpty()) {
			t = q.poll();
			if(t != null && t.data == data)
				return t;
			if(t != null && t.left != null)
				q.add(t.left);
			if(t != null && t.right != null)
				q.add(t.right);
		}
		return null;
	}
}
