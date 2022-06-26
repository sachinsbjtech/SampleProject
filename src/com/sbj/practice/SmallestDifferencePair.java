package com.sbj.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SmallestDifferencePair {

	public static void main(String[] args) {
		Integer inputArra[] = {9,8,7,6,5,4,3,2};
		System.out.println(new SmallestDifferencePair().getSmallestDiffItemPair(Arrays.asList(inputArra)));
	}
	
	List<Integer> getSmallestDiffItemPair(List<Integer> arr){
		Collections.sort(arr);
		System.out.println("Sorted List:"+arr);
		Map<List<Integer>, Integer> pairMap = new HashMap<>();
		
		for(int i = 0; i < arr.size(); i++) {
			for(int j = i+1; j < arr.size();j++) {
				List<Integer> pairList = new ArrayList<Integer>();
				pairList.add((arr.get(i)));
				pairList.add((arr.get(j)));
				pairMap.put(pairList, arr.get(i) - arr.get(j));
			}
		}
		System.out.println("Pair Map:"+pairMap);
		//
		Optional<Integer> minOptional = pairMap.values().stream().min(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("Min Value:"+minOptional.get());
		List<Integer> outputList = new ArrayList<Integer>();
		pairMap.keySet().stream().filter(item ->  
		Math.abs(pairMap.get(item)) ==  Math.abs(minOptional.get())).forEach(item -> {
				
				System.out.println("Filtered List:"+item);
				outputList.addAll(item);
			});

		return outputList;
	}

}
