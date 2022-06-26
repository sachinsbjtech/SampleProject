package com.sbj.nonlinearDS;

public class FindMaxDepthBTree {
	public static void main(String[] args) {

		//[2,2,1,null,1,0,null,0]
		
		TreeNode root = new TreeNode(4);
		//left side
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.left = new TreeNode(6);
        //root.left.left.left = new TreeNode(7);
        //root.left.left.right = new TreeNode(2);
        
        //right side
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
		/*
		 * root.right.left = new TreeNode(13); root.right.right = new TreeNode(4);
		 * root.right.right.right = new TreeNode(1);
		 */
        System.out.println(new FindMaxDepthBTree().maxDepth(root));
	
	}
	
	int maxDepth(TreeNode node) {
		int maxDepth = 0;
		maxDepth = calCulateMaxDepth(node);
		return maxDepth;
	}

	private int calCulateMaxDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int leftHeight = calCulateMaxDepth(node.left);
		int rightHeight = calCulateMaxDepth(node.right);
		return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
	}
}
