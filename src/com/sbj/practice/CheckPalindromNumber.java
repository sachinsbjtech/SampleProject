package com.sbj.practice;

public class CheckPalindromNumber {

	public static void main(String[] args) {
		int x = 0;
		System.out.println(findPalindrom(x));
		
	}
	
	private static boolean findPalindrom(int x) {
		
		String inputString = x+"";
		if(inputString.length() == 1 ) {
			return true;
		}
		int median   = inputString.length() / 2;//inputStringLenght / 2 == 0 ? inputStringLenght / 2 +1  : (inputStringLenght /2) ;
		/*
		 * for(int i = 0, j = inputStringLenght -1 ; i < median && j >= median ; i++,j--
		 * ) { if(inputString.charAt(i) != inputString.charAt(j)) { return false; }
		 * 
		 * }
		 */
		int i = 0, j = inputString.length() -1;
		do {
			if(inputString.charAt(i) != inputString.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}while(i < median && j >= median);
		
		return true;
	}

}
