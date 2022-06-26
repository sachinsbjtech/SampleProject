package com.sbj.practice;

@FunctionalInterface
public interface FuncationalInterface<T, U, V> {
	public V apply(T t , U u);
	
	default void count() {
		//
	}
}
