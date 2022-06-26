package com.sbj.practice;

import java.util.Arrays;
import java.util.List;

//PINALSIGYAHRPI
//PINALSIGYAHRPI
public class ZigZagConversation {
	public static void main(String[] args) {
		System.out.println((new ZigZagConversation()).convert("ABC", 2));
	}
	public String convert(String s, int numRows) {
		if(s.length() ==1 || numRows ==1 ) {
			return s;
		}
		
		int columnLength = s.length() / 2;
		columnLength++;
		
		char zigZagArray [][] = new char[numRows][columnLength];
		int column = 0;
		for(int i =0 ;i < s.length();) {
			for(int j = 0; j < numRows && i < s.length(); j++) {
				zigZagArray[j][column] = s.charAt(i);
				i++;
			}
			column++ ;
			for(int k= numRows -2 ; k > 0 && i < s.length();k-- ) {
				zigZagArray[k][column]= s.charAt(i);
				column++;
				i++;
			}
		}
		String finalString = "";
		for(int i = 0 ; i < zigZagArray.length; i++) {
			for(int j =0  ; j < zigZagArray[i].length ; j++) {
				if(zigZagArray[i][j] != '\u0000') {
					finalString = finalString + zigZagArray[i][j];
				}
			}
		}
		return finalString;
    }
}
