package com.sbj.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindIntersection {

	public static void main(String[] args) {

		Integer arr1[] = {2,4,6,8,10};
		Integer arr2[] = {1,4,6,7,8,9};
		
		Set<Integer> set = new HashSet<>();
		set.addAll(Arrays.asList(arr1));
		set.retainAll(Arrays.asList(arr2));
		System.out.println(set);
		A a = new TestDefault();
		a.m1();
		B b = new TestDefault();
		b.m1();
	}

}

class TestDefault implements B{
	public void printDefault() {
		m1();
	}
}

interface A {
	default void m1() {
		System.out.println("A.m1");
	}
}
interface B extends A{
	default void m1() {
		System.out.println("B.m2");
	}
}
