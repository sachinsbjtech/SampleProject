package com.sbj.practice;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String str[] = {"flower","flow","flight"};
				System.out.println(longestCommonPrefix(str));
	}

	public static String longestCommonPrefix(String[] strs) {

		if(strs.length == 1){
			return strs[0];
		}
		String commonPrefix = strs[0];
		int j = 0;

		for(int i = 1; i < strs.length ; i++){
			for(j=0; strs[i].length() > 0 && j < commonPrefix.length() && strs[i].length() > j ; j++) {
				if(strs[i].charAt(j) != commonPrefix.charAt(j)) {
					//if there is not even single common char start
					if(j == 0) {
						return "";
					}else {
						break;
					}
				}
			}
			commonPrefix = commonPrefix.substring(0, j );
		}
		return commonPrefix;
	}
}
