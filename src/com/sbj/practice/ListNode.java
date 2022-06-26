package com.sbj.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
	public int getVal() {
		return val;
	}
	
	public ListNode getNext() {
		return next;
	}
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		List<Integer> firstNumberList = convertToNumberList(l1);
		List<Integer> secondNumberList = convertToNumberList(l2);
		List<Integer> finalNumberLst = additionOfNumber(firstNumberList, secondNumberList);
		ListNode output = convertoFinalListNode(finalNumberLst);
        System.out.println("Print"+ output);
        return output;
    }
	 
	private List<Integer> additionOfNumber(List<Integer> firstNumberList, List<Integer> secondNumberList){
		List<Integer> finalOuputList = new ArrayList<Integer>();
		List<Integer> longList= new ArrayList<Integer>();
		List<Integer> shortList= new ArrayList<Integer>();
		
		if(firstNumberList.size() > secondNumberList.size()) {
			longList = firstNumberList;
			shortList = secondNumberList;
		}else {
			longList = secondNumberList;
			shortList = firstNumberList;
		}
		int quotient =0;
		for(int i = 0 ; i < longList.size();i++) {
			Integer firstNumber = longList.get(i);
			Integer secondInteger = 0;
			if(shortList.size()  > i) {
				secondInteger = shortList.get(i);
			}
			Integer addition = firstNumber + secondInteger;
			addition+= quotient;
			Integer numberToStore  = addition % 10;
			quotient = addition / 10;
			finalOuputList.add(numberToStore);
		}
		
		// if there is still quotient then add in the list
		if(quotient>0) {
			finalOuputList.add(quotient);
		}
		return finalOuputList;
	}
    
    private ListNode convertoFinalListNode(List<Integer> finalNumberLst) {
    	ListNode finalListNode = new ListNode(finalNumberLst.get(0));
    	ListNode lastNode = finalListNode;
    	if(!finalNumberLst.isEmpty()) {
    		finalNumberLst.remove(0);
    	}
    	for(Integer number : finalNumberLst) {
    		 ListNode localeNode = new ListNode(number);
    		 lastNode.next = localeNode; 
    		 lastNode = localeNode;
    	}
		return finalListNode;
	}
	private List<Integer> convertToNumberList(ListNode l1){
        List<Integer> numberList = new ArrayList<Integer>();
        while(l1!=null){
            numberList.add(l1.val);
            l1 = l1.next;
        }
        
        //Collections.reverse(numberList);
        return numberList;
        
    }
	
	public static void main(String[] args) {
		
		  ListNode n1 = new ListNode(9);
		  
		  ListNode n2 = new ListNode(1); ListNode n3 = new ListNode(9);
		  
		  n2.next = n3;
		  
		  ListNode n4 = new ListNode(9); ListNode n5 = new ListNode(9); ListNode n6 =
		  new ListNode(9); n3.next = n4; n4.next = n5; n5.next = n6; ListNode n7 = new
		  ListNode(9); ListNode n8 = new ListNode(9); ListNode n9 = new ListNode(9);
		  ListNode n10 = new ListNode(9); ListNode n11 = new ListNode(9); n6.next = n7;
		  n7.next = n8; n8.next = n9; n9.next = n10; n10.next = n11;
		  
		  
		  new ListNode().addTwoNumbers(n1,n2);
		
		
		ListNode newn1 = new ListNode(9);
		ListNode newn2 = new ListNode(9);
		ListNode newn3 = new ListNode(9);
		newn1.next = newn2;
		newn2.next = newn3;
		
		ListNode newn4 = new ListNode(9);
		ListNode newn5 = new ListNode(9);
		ListNode newn6 = new ListNode(9);
		ListNode newn7= new ListNode(9);
		ListNode newn8 = new ListNode(9);
		
		newn4.next = newn5;
		newn5.next = newn6;
		newn6.next = newn7;
		newn7.next = newn8;
		
		new ListNode().addTwoNumbers(newn1,newn4);
		
	}
	
	@Override
	public String toString() {
		return val + (next !=null ? next.toString() : "") +"";
	}
}
