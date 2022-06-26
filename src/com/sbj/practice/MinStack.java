package com.sbj.practice;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
	List<Integer> stack = new ArrayList<Integer>();
	int minimum = 0;
	int size=0;
	

	public static void main(String[] args) {
		MinStack minstack = new MinStack();
	    minstack.push(4);
	    minstack.push(7);
	    minstack.push(3);
	    minstack.push(2);
	    minstack.push(6);
	    int min1 = minstack.min();
	    minstack.pop();
	    int min2 = minstack.min();
	    minstack.pop();
	    int min3 = minstack.min();
	    minstack.pop();
	    int min4 = minstack.min();
	    minstack.pop();
	    System.out.println("min1 2, Actual:"+min1);
	    System.out.println("min2 2, Actual:"+min2);
	    System.out.println("min3 3, Actual:"+min3);
	    System.out.println("min4 4, Actual:"+min4);
		
	}

	public void push(int val) {
		if(minimum == 0 || minimum > val) {
			minimum = val;
		}
		stack.add(val);
		size++;
    }

    public int pop() {
    	int itemPoped = stack.remove(size-1);
    	size--;
        return itemPoped;
    }

    public int peek() {
        return stack.get(size);
    }

    public int min() {
    	stack.stream().min((a,b) -> a.compareTo(b));
        return stack.stream().min((a,b) -> a.compareTo(b)).get();
    }
}
