package com.sbj.practice;

public class FindFibonacciNumberSum {
	
	static private long temp[] = new long[100];
	static {
		for(int i = 0; i< temp.length ; i++) {
			temp[i] = -1;
		}
	}
	public static void main(String[] args) {
		System.out.println(fibonnaciSum(47));
	}

	public static long fibonnaciSum(int N) {
		long startTime = System.currentTimeMillis();
		long result = 0; 

		long fibNumber = fiblastNumber(N);

		String finalNumber = fibNumber+"";
		long finalResult = 0;
		
		for(int i =0 ; i < finalNumber.length();i++) { 
			finalResult = finalResult + Integer.parseInt(finalNumber.charAt(i)+""); 
		}
		
		result = finalResult;
		System.out.println((System.currentTimeMillis() -startTime) + "milliSec");

		return result;
	}
	
	private static long fiblastNumber(int N) {
		if(N == 0) {
			return 0;
		}else if( N ==1) {
			return 1;
		}
		if(temp[N] != -1) {
			return temp[N];
		}
		
		return temp[N] = fiblastNumber(N-1) + fiblastNumber(N-2);
	}
}
//10983milliSec
//37

