package com.sbj.practice;

public class FindLongestSubstring {
	
	public static void main(String[] args) {
		System.out.println((new FindLongestSubstring()).lengthOfLongestSubstring("a123  #@%& ABCDa123  #@%& ABCD"));
	}
	public int lengthOfLongestSubstring(String s) {
        if(s == ""){
            return 0;
        }
        String subStr = "";
        int maxSubString = 0;
        for(int l = 0;l < s.length(); l++){
        	char inputChar = s.charAt(l);
        	if(!subStr.contains(inputChar+"")) {
        		subStr = subStr + inputChar;
        	}else {
        		// this is to eliminate earlier part of repeated char
        		subStr =  subStr.substring(subStr.lastIndexOf(inputChar+"")+1) + inputChar + "";
        	}
        	if(maxSubString < subStr.length()) {
    			maxSubString = subStr.length();
    		}
        }
        return maxSubString;
    }
}
