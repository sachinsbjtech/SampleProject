package com.sbj.practice;

import java.util.ArrayList;
import java.util.List;

public class FindSquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findSquareRoot(100);
	}

	private static void findSquareRoot(int num) {
		List<Integer> listOfPrimes = new ArrayList<Integer>();
		listOfPrimes.add(2);
		listOfPrimes.add(3);
		listOfPrimes.add(5);
		listOfPrimes.add(7);
		listOfPrimes.add(11);
		listOfPrimes.add(13);
		listOfPrimes.add(17);
		listOfPrimes.add(19);
		// 
		List<Integer> primeFactorsUsed = new ArrayList<>();
		int nextNum = num;
		
		for(Integer prime : listOfPrimes) {
			while((nextNum % prime) == 0) {
				primeFactorsUsed.add(prime);
				nextNum = nextNum / prime;
			}
			if(nextNum == 1) {
				break;
			}
		}
		int sqrt = 1;
		// take out pair of primes
		for(int i = 0 ; i < primeFactorsUsed.size(); ) {
			sqrt =sqrt * primeFactorsUsed.get(i);
			i =  i+2;
		}
		
		System.out.println("Sqrt:"+sqrt);
	}

}
