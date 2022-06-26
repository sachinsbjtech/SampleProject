package com.sbj.practice;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ConvertDecimalToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//123
		//234 / 10 = 23
		// Number + Zeros AND remaining number after removing first digit
		//convertToRoman(345);
		//System.out.println(Math.pow(10, 3));
		
		System.out.println("Roman :"+convertToRoman(1994));
	}
	static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
	static void initData() {
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
		
	}
	
	static String convertToRoman(int num) {
		initData();
		StringBuffer sb = new StringBuffer();
		
		while(num > 0) {
			Entry<Integer, String> floorValue = map.floorEntry(num);
			sb.append(floorValue.getValue());
			num = num - floorValue.getKey();
		}
		return sb.toString();
	}

	private static String getRomanValue(int num) {
		int firstDigit = num; 
		String romanValue = "";
		int nuberToMultiple = 1;
		while(firstDigit >=10) {
			firstDigit = firstDigit/10;
		}
		
		System.out.println(firstDigit);
		romanValue = compareAndReturnRoman(firstDigit * nuberToMultiple);
		return romanValue;
	}

	private static String compareAndReturnRoman(int num) {
		if(num ==1 ) {
			return "I";
		}else if(num == 2) {
			return "II";
		}else if(num == 3 ) {
			return "III";
		}else if(num == 4 ) {
			return "IV";
		}else if(num == 5) {
			
		}
		return null;
	}

}
