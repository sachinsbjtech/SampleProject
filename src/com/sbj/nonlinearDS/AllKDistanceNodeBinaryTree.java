package com.sbj.nonlinearDS;

import java.util.ArrayList;
import java.util.List;

public class AllKDistanceNodeBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		//left side
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        //root.left.left.left = new TreeNode(7);
        //root.left.left.right = new TreeNode(2);
        
        //right side
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
		/*
		 * root.right.left = new TreeNode(13); root.right.right = new TreeNode(4);
		 * root.right.right.right = new TreeNode(1);
		 */
        AllKDistanceNodeBinaryTree ref = new AllKDistanceNodeBinaryTree();
        ref.distanceK(root, new TreeNode(6), 2);
        System.out.println(ref.list);
	}
	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		
		findKDistanceNodes(root, target.val, k, 0);
		//when target node is found 
        return list;
    }
	private int findKDistanceNodes(TreeNode root, int target, int k, int actualDistance) {
		if(root ==null) {
			return 0;
		}
		
		// no need to traverse further as we reached K distance
		if(actualDistance == k) {
			list.add(root.val);
			return 0;
		}

		int left = findKDistanceNodes(root.left, target, k, (root.val == target || actualDistance > 0) ? actualDistance +1 :actualDistance);
		int right = findKDistanceNodes(root.right, target, k, (root.val == target || actualDistance > 0) ? actualDistance +1 :actualDistance);
		
		// when target value is found
		if(root.val == target) {
			return 1;
		}
		
		// when left or right if at K distance from current 
		if(right == k || left == k) {
			list.add(root.val);
			return 0;
		}
		
		// left > 0 mean current node is at upper level than target group and is at left subtree of current 
		// now traverse through right subtree of current node to find K distance nodes
		// left +1 mean we are returning its value to its parent 
		if(left > 0) {
			findKDistanceNodes(root.right, target, k, left +1);
			return left + 1;
		}
		
		if(right > 0) {
			findKDistanceNodes(root.left, target, k, right + 1);
			return right + 1;
		}
			
		
		return 0;
	}
}
