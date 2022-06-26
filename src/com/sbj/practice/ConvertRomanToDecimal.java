package com.sbj.practice;

import java.util.TreeMap;

public class ConvertRomanToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("MCMXCIV"));
	}

	static TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
	static void initData() {
		
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);
	}
	
	public static int romanToInt(String s) {
		int decimalValue = 0;
		char current = Character.MIN_VALUE ;
		char previous = Character.MIN_VALUE;
		initData();
		for(int i = s.length()-1 ; i >= 0 ; i--) {
			current = s.charAt(i);
			
			
			if(current == 'I' && (previous == 'V' || previous == 'X') ) {
				decimalValue-=map.get('I');
			}else if(current == 'X' && (previous == 'L' || previous == 'C') ) {
				decimalValue-=map.get('X');
			}else if(current == 'C' && (previous == 'D' || previous == 'M')) {
				decimalValue-=map.get('C');
			}else {
				decimalValue+=map.get(current);
			}
			previous = current;
		}
    return  decimalValue;
    }
}
