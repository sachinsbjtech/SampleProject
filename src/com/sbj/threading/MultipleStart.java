package com.sbj.threading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MultipleStart extends Thread{
	
	@Override
	public void run() {
		System.out.println("Test");
	}

	public static void main(String[] args) {
		MultipleStart s = new MultipleStart();
		s.start();
		//s.start();
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(4);
		Optional<Integer> opt = list.stream().reduce(Integer::sum);
		System.out.println(opt.get());
		
		//list.stream().flatMap( i -> Arrays.asList(i));
		list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
	}

}
