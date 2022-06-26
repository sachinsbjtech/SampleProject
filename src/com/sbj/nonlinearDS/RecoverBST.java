package com.sbj.nonlinearDS;

import java.util.ArrayList;
import java.util.List;

public class RecoverBST {

	static TreeNode firstIncorrectNode = null;
    static TreeNode secondIncorrectNode = null;
    static TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
	public static void main(String[] args) {

		//3,1,4,null,null,2
		
		TreeNode root = new TreeNode(3);
		//left side
        root.left = new TreeNode(1);
        //root.left.left = new TreeNode(1);
        //root.left.right = new TreeNode(2);
        //root.left.right.left = new TreeNode(0);
        //root.left.left.left = new TreeNode(7);
        //root.left.left.right = new TreeNode(2);
        
        //right side
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        //root.right.right = new TreeNode(2);
		/*
		 * root.right.left = new TreeNode(13); root.right.right = new TreeNode(4);
		 * root.right.right.right = new TreeNode(1);
		 */
        recoverTree(root);
	System.out.println("Done");

	}
	
	public static void recoverTree(TreeNode root) {
		inTraverseThroughTree(root);
        int tempVal = firstIncorrectNode.val;
        firstIncorrectNode.val = secondIncorrectNode.val;
        secondIncorrectNode.val = tempVal;
		
    }

	private static void inTraverseThroughTree(TreeNode root) {
		if(root == null) {
			return;
		}
		
		inTraverseThroughTree(root.left);
		//Write logic to identify two numbers
            if(firstIncorrectNode ==null && prevNode.val >= root.val){
            	firstIncorrectNode = prevNode;
            }
            
            if(firstIncorrectNode!=null && prevNode.val >= root.val){
            	secondIncorrectNode = root;
            }
            
            prevNode = root;
                
		inTraverseThroughTree(root.right);
	}
}
