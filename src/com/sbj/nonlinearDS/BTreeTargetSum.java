package com.sbj.nonlinearDS;

public class BTreeTargetSum {

	public static void main(String[] args) {
		//5,4,8,11,null,13,4,7,2,null,null,null,1
		
		TreeNode root = new TreeNode(5);
		//left side
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        
        //right side
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        
        System.out.println(hasPathSum(root, 22));
	}
	
	public static boolean hasPathSum(TreeNode root, int targetSum) {
		int calculatedSum = 0;
		return findMaxSumPath(root, targetSum, calculatedSum);
    }

	private static boolean findMaxSumPath(TreeNode root, int targetSum, int calculatedSum) {
		if(root == null) {
			return false;
		}
		
		int nodeValue = root.val;
		calculatedSum+= nodeValue;
		boolean leftValue  =  findMaxSumPath(root.left, targetSum,calculatedSum);
		if(leftValue == true) {
			return true;
		}
		boolean rightValue =  findMaxSumPath(root.right, targetSum,calculatedSum);
		if(rightValue == true) {
			return true;
		}
		
		if(root.left == null && root.right == null) {
			
			return Integer.compare(calculatedSum, targetSum) == 0 ? true : false;
			
		}
		
		return false;
	}

}
