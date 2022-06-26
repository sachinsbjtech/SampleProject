package com.sbj.nonlinearDS;

import java.util.concurrent.atomic.AtomicInteger;

public class BTreeMaxPath {
	
	static int max;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-2);
        //root.left = new TreeNode(2);
        root.right = new TreeNode(-1);
		/*
		 * root.left.left = new TreeNode(-1); root.left.right = new TreeNode(-4);
		 * root.right.left = new TreeNode(-5); root.right.right = new TreeNode(-6);
		 * root.left.right.left = new TreeNode(4); root.right.left.left = new
		 * TreeNode(7); root.right.left.right = new TreeNode(4);
		 * root.right.left.left.right = new TreeNode(-2);
		 */
        System.out.println(maxPathSum(root));
	}
	
	 public static int maxPathSum(TreeNode root) {
		 max = Integer.MIN_VALUE;
		 if(root.left == null && root.right == null){
	            return root.val;
	        }
	         findMaxPathSum(root);
	         return max;
	    }
	  
	 public static int findMaxPathSum(TreeNode root) {
	        if(root == null){
	            return 0;
	        }
	        
	        int nodeValue = root.val;
	        int leftValue = findMaxPathSum(root.left);
	        int rightValue = findMaxPathSum(root.right);
	        
		/*
		 * int max = nodeValue; if(root.left !=null) { max = Integer.max(nodeValue,
		 * leftValue); max = Integer.max(max, nodeValue + leftValue); } if(root.right
		 * !=null) { max = Integer.max(max, rightValue); max = Integer.max(max,
		 * nodeValue + rightValue); }
		 */
	        int leftRightMax ;
	        if(root.left == null) {
	        	leftRightMax = rightValue;
	        } if(root.right == null) {
	        	leftRightMax = rightValue;
	        }else {
	        	leftRightMax = Integer.max(leftValue, rightValue);
	        }
	        //int max = Integer.max(nodeValue, leftRightMax);
	        int maxOneNodeRoot = Integer.max(nodeValue, nodeValue + leftRightMax);
	        //max = Integer.max(max, rightValue);
		/*
		 * max = Integer.max(max, nodeValue + leftValue); max = Integer.max(max,
		 * nodeValue + rightValue);
		 */
	        
	        int maxAll = Integer.max(maxOneNodeRoot,nodeValue + leftValue + rightValue);
	        max = Integer.max(max, maxAll);
		/*
		 * if(root.left !=null && root.right!=null) { max = Integer.max(max,nodeValue +
		 * leftValue + rightValue); }
		 */
	        
	        return maxOneNodeRoot;
	    }

	private int findMaxSum(TreeNode A, AtomicInteger result) {
		if(A == null) {
			 return 0;
		 }
		 
		 int nodeValue =  A.val;
		 int leftTreeValue = maxPathSum(A.left);
		 int rightTrrValue = maxPathSum(A.right);
		 
		 if(nodeValue < (A.val + leftTreeValue)) {
			 nodeValue = (A.val + leftTreeValue);
			 if(nodeValue < (A.val + leftTreeValue+rightTrrValue)) {
				 nodeValue = (A.val + leftTreeValue+rightTrrValue);
			 }
		 }
		 int max = result.get();
		 max = Math.max(max, nodeValue);
		 max = Math.max(max, nodeValue + leftTreeValue);
		 max = Math.max(max,  nodeValue + rightTrrValue);
		 max = Math.max(max, nodeValue + leftTreeValue + rightTrrValue);
		 result.set(max);
		 
		 return Math.max(nodeValue, nodeValue + Integer.max(leftTreeValue, rightTrrValue));
	}
	 
}

class TreeNode {
	       int val;
	       TreeNode left;
	       TreeNode right;
	       TreeNode(int x) {
	        val = x;
	        left=null;
	        right=null;
	       }
	       
	       TreeNode(int v, TreeNode left, TreeNode right){
	    	   val = v;
	    	   this.left = left;
	    	   this.right = right;
	       }
	   }