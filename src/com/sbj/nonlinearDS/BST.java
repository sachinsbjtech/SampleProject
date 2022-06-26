package com.sbj.nonlinearDS;

public class BST {
	
	private MyTree parentNode;
	

	
	public MyTree addNode(MyTree parentNode, Integer nodeToBeAdded) {
		if(parentNode == null) {
			return new MyTree(nodeToBeAdded);
		}
		
		if(parentNode != null && parentNode.getValue() > nodeToBeAdded ) {
			// add to left
			MyTree node = addNode(parentNode.getLeft(), nodeToBeAdded);
			System.out.println("LEFT parentNode :"+parentNode.getValue()+", nodeToBeAdded :"+nodeToBeAdded);
			if(node != null) {
				parentNode.setLeft(new MyTree(nodeToBeAdded));
			}
		}else {
			MyTree node = addNode(parentNode.getRight(), nodeToBeAdded);
			System.out.println("RIGHT parentNode :"+parentNode.getValue()+", nodeToBeAdded :"+nodeToBeAdded);
			if(node != null) {
				parentNode.setRight(new MyTree(nodeToBeAdded));
			}
		}
		return null;
	}
	// 36 43 50 56 65
	public void inOrderTraversal(MyTree parentNode) {
		if(parentNode == null) {
			return;
		}
		inOrderTraversal(parentNode.getLeft());
		System.out.print(parentNode.getValue() +" ");
		inOrderTraversal(parentNode.getRight());
	}
	
	public void preOrderTraversal(MyTree parentNode) {
		if( parentNode == null ) {
			return;
		}
		System.out.print(parentNode.getValue() +" ");
		inOrderTraversal(parentNode.getLeft());
		inOrderTraversal(parentNode.getRight());
	}
	
	public void postOrderTraversal(MyTree parentNode) {
		if( parentNode == null ) {
			return;
		}
		
		inOrderTraversal(parentNode.getLeft());
		inOrderTraversal(parentNode.getRight());
		System.out.print(parentNode.getValue() +" ");
	}
	
	public void leafNodeFinder(MyTree parentNode) {
		if(parentNode == null) {
			return;
		}
		if(parentNode.getLeft() == null && parentNode.getRight() == null) {
			System.out.println("Leaf Node:"+parentNode.getValue());
			return;
		}
		
		leafNodeFinder(parentNode.getLeft());
		leafNodeFinder(parentNode.getRight());
		
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.parentNode = new MyTree(50);
		bst.addNode(bst.parentNode, 36);
		bst.addNode(bst.parentNode, 56);
		bst.addNode(bst.parentNode, 65);
		bst.addNode(bst.parentNode, 43);
		bst.inOrderTraversal(bst.parentNode);
		System.out.println();
		bst.preOrderTraversal(bst.parentNode);
		System.out.println();
		bst.postOrderTraversal(bst.parentNode);
		System.out.println();
		bst.leafNodeFinder(bst.parentNode);
	}
	
}

class MyTree{
	
	private Integer value;
	private MyTree left;
	private MyTree right;
	
	public MyTree(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public MyTree getLeft() {
		return left;
	}

	public void setLeft(MyTree left) {
		this.left = left;
	}

	public MyTree getRight() {
		return right;
	}

	public void setRight(MyTree right) {
		this.right = right;
	}
}
