package com.sbj.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PostfixEquationEvaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(expressionEval("231*+9-"));
	}
	
	public static int expressionEvaluation(String s) {

		Stack<Character> operators = new Stack<Character>();
		Set<Character> setOfOperators = new HashSet<Character>();
		setOfOperators.add('+');
		setOfOperators.add('*');
		setOfOperators.add('-');
		int finalValue = 0;
		for(int i = s.length() -1 ; i >=0 ; i--){
			if(setOfOperators.contains(s.charAt(i))){
				operators.push(s.charAt(i));
				continue;
			}
			Character operator = operators.pop();
			Character operand = s.charAt(i);
			finalValue = expressionEvaluation(finalValue, operand, operator);

		}
		return finalValue;
	}
	
	private static int expressionEvaluation(int finalValue, Character operand, Character operator){
		String stringOperand = operand.toString();
		switch(operator){
			case '+':
				finalValue = finalValue + Integer.parseInt(stringOperand);
				break;
			case '-':
				finalValue = finalValue - Integer.parseInt(stringOperand);
				break;
			case '*':
				finalValue = finalValue * Integer.parseInt(stringOperand);
				break;
		}
		return finalValue;
	}
	
	private static int expressionEvaluationNEW(int finalValue, int operand, Character operator){
		switch(operator){
			case '+':
				finalValue = finalValue + operand;
				break;
			case '-':
				finalValue = finalValue - operand;
				break;
			case '*':
				finalValue = finalValue * operand;
				break;
		}
		return finalValue;
	}
	
	static int expressionEval( String s ) {
		int finalValue  =0 ;
		Stack<Integer> stack = new Stack<Integer>();
		Set<Character> setOfOperators = new HashSet<Character>();
		setOfOperators.add('+');
		setOfOperators.add('*');
		setOfOperators.add('-');
		for(int i =0 ; i < s.length() ; i++) {
			if(setOfOperators.contains(s.charAt(i))){
				int topElemet1 = stack.pop();
				int topElemet2 = stack.pop();
				finalValue = expressionEvaluationNEW( topElemet2,topElemet1, s.charAt(i));
				stack.push(finalValue);
			}else {
				stack.push(Integer.parseInt(s.charAt(i)+""));
			}
		}
		return finalValue; 
	}

}
