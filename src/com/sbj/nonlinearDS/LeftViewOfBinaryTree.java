package com.sbj.nonlinearDS;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBinaryTree {

	public static void main(String[] args) {


		//[2,2,1,null,1,0,null,0]
		
		TreeNode root = new TreeNode(1);
		//left side
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //root.left.left.left = new TreeNode(3);
        //root.left.right.right = new TreeNode(5);
        //root.left.right.right.left = new TreeNode(6);
        //root.left.left.left = new TreeNode(7);
        //root.left.left.right = new TreeNode(2);
        
        //right side
        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(6);
        //root.right.left.right = new TreeNode(10);
		/*
		 * root.right.left = new TreeNode(13); root.right.right = new TreeNode(4);
		 * root.right.right.right = new TreeNode(1);
		 */
        System.out.println(new LeftViewOfBinaryTree().getLeftView(root));
	
	
	}
	
	public List<Integer> getLeftView(TreeNode node) {
		List<Integer> list = new ArrayList<>();
		getLeftViewNodes(node,list);
		return list;
	}

	private void getLeftViewNodes(TreeNode node, List<Integer> list) {
		if(node ==null) {
			return;
		}
		
		if(node.left!=null) {
			list.add(node.left.val);
		}
		getLeftViewNodes(node.left, list);
		getLeftViewNodes(node.right, list);
	}

}
