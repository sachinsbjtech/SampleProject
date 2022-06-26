package com.sbj.practice;

import java.util.HashSet;
import java.util.Set;

public class PythagoreanTriplet {
	// a2 = b2 + c2;
	public static void main(String[] args) {
		int arr[] = {10, 4, 6, 12, 5};
		System.out.println(new PythagoreanTriplet().checkIfPyathagoranTriplet(arr));

	}
	
	public boolean checkIfPyathagoranTriplet(int arr[]) {
		boolean isPyathagorianTriplet = false;
		
		
		
		for(int i = arr.length -1 ; i > -1 ; i--) {
			Set<Integer> hashSet = new HashSet<Integer>();
			for(int j = 0 ; j < i ; j++) {
				// Logic is if a2 and b2 are known then c2 can be calculated as c2 = a2 - b2
				// check b2 is exist in hasset if yes means a2 = b2 + c2 is present
				// if c2 is not present in hashset then add it into the set  
				int bSqaure = (arr[j] * arr[j]);
				if(hashSet.contains(bSqaure)) {
					return true;
				}
				int cSquare = ((arr[i] * arr[i]) - bSqaure);
				hashSet.add(cSquare);
			}
		}
		
		return isPyathagorianTriplet;
	}

}
