package com.sbj.practice;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger {

	public static void main(String[] args) {
		System.out.println((new StringToInteger()).myAtoi("20000000000000000000"));

	}
	
	public int myAtoi(String s) {
		if(s== null || s.isEmpty()) {
			return 0;
		}
        String sign ="";
        String stringToProcess =s.trim();
        String chatWhitespacesPattern = "([+ | -]?)([0-9]+)";
		/*
		 * if(stringToProcess.startsWith("+") || stringToProcess.startsWith("-")){ sign
		 * = stringToProcess.charAt(0)+""; stringToProcess =
		 * stringToProcess.substring(1); }
		 */
        
        try{
        	BigInteger valueToReturn = new BigInteger(sign+stringToProcess);
        	
            return getValueToReturn(valueToReturn);
        } catch(NumberFormatException e){
            Pattern pattern = Pattern.compile(chatWhitespacesPattern);
            Matcher matcher = pattern.matcher(stringToProcess);
            if(matcher.find()) {
            	String group =  matcher.group();
            	group = group.trim();
            	if(!stringToProcess.startsWith(group)) {
            		return 0;
            	}
            	stringToProcess = group;
            }else {
            	return 0;
            }
            
            return getValueToReturn(new BigInteger(sign+stringToProcess));
        }
    }
	
	private int getValueToReturn(BigInteger valueToReturn) {
		BigInteger minLimit = new BigInteger("-2");
		BigInteger maxLimit = new BigInteger("2");
		if(valueToReturn.compareTo(minLimit.pow(31)) == -1) {
    		return (int)Math.pow(-2, 31) ;
    	} else if(valueToReturn.compareTo(maxLimit.pow(31)) >= 0) {
    		return (int)Math.pow(2, 31);
    	}
		return valueToReturn.intValue();
	}

}
