package com.sbj.practice;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapPractice {
	public static void main(String[] args) {
		String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		  Stream.of(array).flatMap(Stream::of).collect(Collectors.toList()).forEach( i -> System.out.println(i));
		  
		  //Stream.of(array).flatMap(( ar[]) -> String.valueOf(ar) )
	}
}
