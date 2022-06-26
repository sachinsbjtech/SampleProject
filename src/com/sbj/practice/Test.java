package com.sbj.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class Test{

	public static void main(String args[]){
		int A[] = {1,2,3,4,5,6};
		System.out.println(getDesiredPair(A));
		
		List<Emp> list = new ArrayList<Emp>();
		Emp e = new Emp();
		e.setId(123);
		list.add(e);
		
		ConcurrentHashMap<Integer, List<Emp>> map = new ConcurrentHashMap<Integer, List<Emp>>();
		map.put(123, list);
		
		Map<Integer, List<Emp>> mapCopy = map.entrySet().
				stream().collect(Collectors.toMap(item -> item.getKey(), item -> new ArrayList(item.getValue())));
        
		mapCopy.get(123).get(0).setId(111);
		System.out.println("Original::"+map.get(123).get(0).getId());
		System.out.println("Copy::"+mapCopy.get(123).get(0).getId());
	}
	
	private static int getDesiredPair(int A[]){
		int totalCount = 0;
		
		for(int i = 0; i < A.length; i++){
			for(int j =  A.length -1 ; j > i ; j--){
				if((A[j] - A[i])==(j - i)){
					totalCount++;
					System.out.println("i :"+i+", j:"+j);
				}
				
			}
		}
		
		return totalCount;
	
	}

}

class Emp {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}