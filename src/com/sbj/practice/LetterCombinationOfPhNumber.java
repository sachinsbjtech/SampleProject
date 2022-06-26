package com.sbj.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class LetterCombinationOfPhNumber {
	public static void main(String[] args) {
		//System.out.println(letterCombinations("5678"));
		System.out.println(letterCombinations1("5678"));
	}
	
	static Map<Integer, List<String>> letterMap = new HashMap<Integer, List<String>>();
	
	static {
		List<String> l2 = new ArrayList<String>();
		l2.add("a");l2.add("b");l2.add("c");
		
		List<String> l3 = new ArrayList<String>();
		l3.add("d");l3.add("e");l3.add("f");
		
		List<String> l4 = new ArrayList<String>();
		l4.add("g");l4.add("h");l4.add("i");
		
		List<String> l5 = new ArrayList<String>();
		l5.add("j");l5.add("k");l5.add("l");
		
		List<String> l6 = new ArrayList<String>();
		l6.add("m");l6.add("n");l6.add("o");
		
		List<String> l7 = new ArrayList<String>();
		l7.add("p");l7.add("q");l7.add("r");l7.add("s");
		
		List<String> l8 = new ArrayList<String>();
		l8.add("t");l8.add("u");l8.add("v");
		
		List<String> l9 = new ArrayList<String>();
		l9.add("w");l9.add("x");l9.add("y");l9.add("z");
	
		letterMap.put(2, l2);
		letterMap.put(3, l3);
		letterMap.put(4, l4);
		letterMap.put(5, l5);
		letterMap.put(6, l6);
		letterMap.put(7, l7);
		letterMap.put(8, l8);
		letterMap.put(9, l9);
	}
	public static List<String> letterCombinations(String digits) {
		
        if(digits == null || digits.isEmpty()) {
        	return new ArrayList<String>();
        }
        
        if(digits.length() == 1 ) {
        	return letterMap.get(Integer.parseInt(digits));
        }
        
        //when length is > 1 
        List<String> finalList = new CopyOnWriteArrayList<String>();
        List<String> finalListWithAll = new CopyOnWriteArrayList<String>();
        // ((12)3)
        List<String> firstDigitList = letterMap.get(Integer.parseInt(digits.charAt(0)+""));
        List<String> secondDigitList = letterMap.get(Integer.parseInt(digits.charAt(1)+""));
        for(String char1 : firstDigitList) {
        	for(String char2 : secondDigitList) {
        		finalList.add(char1+char2);
        	}
        }
        
        // from here onward map earlier output with 3rd char onward 
        for(int i = 2; i < digits.length() ; i++) {
        	List<String> nextDigitLetters = letterMap.get(Integer.parseInt(digits.charAt(i)+""));
        	for(String str: finalList) {
        		finalListWithAll.add(str+nextDigitLetters.get(0));
        		finalListWithAll.add(str+nextDigitLetters.get(1));
        		finalListWithAll.add(str+nextDigitLetters.get(2));
        		if(nextDigitLetters.size() ==4) {
        			finalListWithAll.add(str+nextDigitLetters.get(3));
        		}
        		finalListWithAll.remove(str);
        	}
        	finalList = finalListWithAll;
        }
        
        return finalListWithAll.size() > 0 ? finalListWithAll : finalList;
    }
	
	public static List<String> letterCombinations1(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
}
