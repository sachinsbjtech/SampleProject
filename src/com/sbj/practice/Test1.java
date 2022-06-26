package com.sbj.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Test1 {
	default void m1() {
		System.out.println("Test1");
	}
	
	default void m2() {
	}
}

interface Test2 extends Test1{
	default void m1() {
		List<String> list = new ArrayList<String>();
		list.stream().collect(Collectors.toList()).forEach(i -> i.toString());
		System.out.println("Test2");
	}
}


class MyTest implements Test2{
	public static void main(String[] args) {
		Test1 t1 = new MyTest();
		t1.m1();
		
		MyTest myTest = new MyTest();
		
		List<MyTest> myTestList = new ArrayList<MyTest>();
		myTestList.forEach(MyTest::showMsg);
		
		Optional<String> opt = Optional.ofNullable("123");
		Optional<String> opt1 = Optional.ofNullable("000123");
		List<Optional<String>> listOpt = new ArrayList<Optional<String>>();
		listOpt.add(opt);
		listOpt.add(opt1);
		System.out.println("Optional::"+listOpt.stream().map(Optional::stream).collect(Collectors.toList()));
		
	}
	
	public static void showMsg(MyTest myTest) {
		System.out.println("!!!");
	}
}