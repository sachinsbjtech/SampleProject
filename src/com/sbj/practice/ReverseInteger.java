package com.sbj.practice;

public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(123));
	}
	public int reverse(int x) {
			if(x ==0) {
				return 0;
			}
			int maxValue = Integer.MAX_VALUE;
			int minValue = Integer.MIN_VALUE;
			System.out.println(maxValue);
			System.out.println(minValue);
			System.out.println(x);
			int sigNum = Integer.signum(x);
			StringBuffer sf = new StringBuffer(Math.abs(x)+"");
			String reversedString = sf.reverse().toString().replaceAll("^0+", "");
			System.out.println(reversedString);
			try {
			if(Integer.parseInt(reversedString) > maxValue) {
				return 0;
			}else if(Integer.parseInt(reversedString) < minValue) {
				return 0;
			}else {
				return sigNum < 0 ? - Integer.parseInt(reversedString) : Integer.parseInt(reversedString);
			}
			}catch(NumberFormatException e) {
				if(reversedString.compareTo(maxValue+"") > 0) {
					return 0;
				}else if(reversedString.compareTo(maxValue+"") < 0) {
					return 0;
				}else {
					return sigNum < 0 ? - Integer.parseInt(reversedString) : Integer.parseInt(reversedString);
				}
			}
			
	}
}
