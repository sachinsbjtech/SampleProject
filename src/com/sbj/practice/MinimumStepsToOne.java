package com.sbj.practice;

public class MinimumStepsToOne {
	public static void main(String[] args) {
		System.out.println(stepsToOne(11));
	}
	
	static int stepsToOne(int num) {
		if(num ==1 ) {
			return 1;
		}
		int stepsNeeded = 0;
		if(num %2 == 1) {
			stepsNeeded+=1;
		}
		do{
			num = num /2;
			stepsNeeded+=1;
		}while(num > 1);
		return stepsNeeded;
	}
}
