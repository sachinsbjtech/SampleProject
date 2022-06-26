package com.sbj.nonlinearDS;

public class RootToLeafSum {
	public static void main(String[] args) {
		//5,4,8,11,null,13,4,7,2,null,null,null,1
		
		TreeNode root = new TreeNode(4);
		//left side
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        //root.left.left.left = new TreeNode(7);
        //root.left.left.right = new TreeNode(2);
        
        //right side
        root.right = new TreeNode(0);
		/*
		 * root.right.left = new TreeNode(13); root.right.right = new TreeNode(4);
		 * root.right.right.right = new TreeNode(1);
		 */
        
        System.out.println(sumNumbers(root));
	}
	
	public static int sumNumbers(TreeNode root) {
		return findSumToLeaf(root, 0);
    }
	
	private static int findSumToLeaf(TreeNode root, int calculatedValue) {
		if(root == null) {
			return 0;
		}
		
		int nodeValue = root.val;
		calculatedValue += nodeValue;
		if(root.left == null && root.right == null) {
			return calculatedValue;
		}
		int leftValue =findSumToLeaf(root.left, calculatedValue * 10);
		int rightValue = findSumToLeaf(root.right,  calculatedValue * 10);
		
		
		return leftValue + rightValue;
	}

}
