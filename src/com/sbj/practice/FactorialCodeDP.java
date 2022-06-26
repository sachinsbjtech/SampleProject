package com.sbj.practice;

import java.util.Scanner;

public class FactorialCodeDP {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        //int noOfTC = Integer.parseInt(s.nextLine());  
        int firstInput = Integer.parseInt(s.nextLine());

        System.out.println(factorial(firstInput));
	}
	
	static long factorial(long num){
        if(num ==1){
            return 1;
        }
        return num * factorial(num -1);
    }

}
