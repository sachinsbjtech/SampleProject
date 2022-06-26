package com.sbj.nonlinearDS;

public class BTreeColouringGame {

	public static void main(String[] args) {

		//3,1,4,null,null,2
		
		TreeNode root = new TreeNode(1);
		//left side
        root.left = new TreeNode(2);
        //root.left.left = new TreeNode(1);
        //root.left.right = new TreeNode(2);
        //root.left.right.left = new TreeNode(0);
        //root.left.left.left = new TreeNode(7);
        //root.left.left.right = new TreeNode(2);
        
        //right side
        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(2);
        //root.right.right = new TreeNode(2);
		/*
		 * root.right.left = new TreeNode(13); root.right.right = new TreeNode(4);
		 * root.right.right.right = new TreeNode(1);
		 */
        System.out.println(new BTreeColouringGame().btreeGameWinningMove(root, 3, 2));
        System.out.println("Done");

	}
	int leftHeight = 0;
	int rightHeight = 0;
	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		
		findXNodeTreeNodes(root,x);
		if(( n - (leftHeight + rightHeight + 1)) > n/2) {
			return true;
		}else if( ((leftHeight) > n/2) || (rightHeight > n/2) ) {
			return true;
		}
		
		return false;
		
	}
	

	private int findXNodeTreeNodes(TreeNode root, int x) {

		if(root == null) {
			return 0;
		}
		int l = findXNodeTreeNodes(root.left, x);
		int r = findXNodeTreeNodes(root.right, x);
		
		if(root.val == x) {
			leftHeight = l;
			rightHeight = r;
		}
		
		return l + r + 1;
	}

}
