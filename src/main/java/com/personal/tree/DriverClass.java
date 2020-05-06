package com.personal.tree;

public class DriverClass {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		System.out.println("************* Creating Tree ****************");
		for(int i = 1;i<=10;i++) {
			bt.insertNode(i);
		}
		
		System.out.println("************* Preorder traversal ****************");
		bt.printTreePreOrder(bt.root);
		System.out.println();
		System.out.println("************* Postorder traversal ***************");
		bt.printTreePostOrder(bt.root);
		System.out.println();
		System.out.println("************* Inorder traversal *****************");
		bt.printTreeInorder(bt.root);
		System.out.println();
		System.out.println("************* Levelorder traversal **************");
		bt.printTreeLevelOrder();
		
		System.out.println();
		System.out.println("************* Searching of Node **************");
		bt.searchNode(3);
		
		System.out.println();
		System.out.println("************* Deleting of Node **************");
		bt.deleteNode(3);
		System.out.println();
		System.out.println("************* Levelorder traversal **************");
		bt.printTreeLevelOrder();
	}
}
