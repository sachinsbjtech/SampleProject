package com.sbj.practice;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		LongestCommonSubSequence lcss = new LongestCommonSubSequence();
		System.out.println(lcss.longestCommonSubsequence("acd", "eafcd", 0 , 0 ));
		
	}
	
	public int longestCommonSubsequence(String text1, String text2, int i , int j) {
		int length = 0 ;
		if(i > text1.length()-1  || j > text2.length()-1 ) {
			
			return length;
		}
		
		if(text1.charAt(i) == text2.charAt(j)) {
			length = 1 + longestCommonSubsequence(text1,text2, i+1, j+1);
		}else {
			length =  length + Math.max(longestCommonSubsequence(text1, text2, i , j+1), 
					longestCommonSubsequence(text1, text2, i+1 , j));
		}
		return length;
    }

}
