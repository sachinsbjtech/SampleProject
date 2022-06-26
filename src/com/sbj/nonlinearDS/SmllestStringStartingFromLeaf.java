package com.sbj.nonlinearDS;

public class SmllestStringStartingFromLeaf {

	public static void main(String[] args) {
		//[2,2,1,null,1,0,null,0]
		
		TreeNode root = new TreeNode(4);
		//left side
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(1);
        //root.left.right = new TreeNode(1);
        //root.left.right.left = new TreeNode(0);
        //root.left.left.left = new TreeNode(7);
        //root.left.left.right = new TreeNode(2);
        
        //right side
        root.right = new TreeNode(1);
        //root.right.left = new TreeNode(0);
        //root.right.right = new TreeNode(2);
		/*
		 * root.right.left = new TreeNode(13); root.right.right = new TreeNode(4);
		 * root.right.right.right = new TreeNode(1);
		 */
        System.out.println(smallestFromLeaf(root));
	}
	
	public static String smallestFromLeaf(TreeNode root) {
		if(root == null) {
			return "";
		}
		
		//String leftString = smallestFromLeaf(root.left);
		//String rightString = smallestFromLeaf(root.right);
		/*
		 * if(getLxicographicalValue(leftString) > getLxicographicalValue(rightString))
		 * { return rightString + (char)(97+root.val); }else { return leftString +
		 * (char)(97+root.val); }
		 */
		return compareLeftRight(smallestFromLeaf(root.left),smallestFromLeaf(root.right))+(char)(97+root.val);
    
    }
	
	
	private static String compareLeftRight(String left , String right) {
		
		
		for(int i = 0 ; i < left.length() && i < right.length() ; i++) {
			if(Character.compare(left.charAt(i), right.charAt(i)) > 0){
				return right;
			}else if(Character.compare(left.charAt(i), right.charAt(i)) < 0) {
				return left;
			}
		}
		// when control reches here all smallest string chars are same as long string
		return left.length() > right.length() ? left : right;
	}
	private static int getLxicographicalValue(String input) {
		int lexicoGraphiValue = 0;
		for(int i =0 ; i < input.length(); i++) {
			lexicoGraphiValue+= input.charAt(i);
		}
		return lexicoGraphiValue;
	}
	
	

}
