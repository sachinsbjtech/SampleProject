package com.sbj.practice;

public class PatternMatching {
	public static void main(String[] args) {
		new PatternMatching().isMatch("aab", "c*a*b");
	}
	 public boolean isMatch(String s, String p) {
	        System.out.println(p.indexOf("*"));
	        for(int i =0 ; i< p.length();i++) {
	        	if(p.charAt(i)=='*') {
	        		oneOrMany(p.substring(0, i-1),s);
	        	}
	        }
	        return false;
	 }
	private boolean oneOrMany(String pattern, String input) {
			if(input.substring(0, pattern.length()-1).equals(pattern)) {
				return true;
			}
			return false;
	}
}
