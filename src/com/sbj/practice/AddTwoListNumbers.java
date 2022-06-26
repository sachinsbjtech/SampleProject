package com.sbj.practice;

public class AddTwoListNumbers {

	public static void main(String[] args) {
		// L1 
		ListNode firstNode = new ListNode(9);
		firstNode.next = new ListNode(9);
		firstNode.next.next = new ListNode(9);
		firstNode.next.next.next = new ListNode(9);
		firstNode.next.next.next.next = new ListNode(9);
		
		// L2
		ListNode secondNode = new ListNode(9);
		secondNode.next = new ListNode(9);
		secondNode.next.next = new ListNode(9);
		
		ListNode finalNode = addTwoNumbersNew(firstNode, secondNode);
		while (finalNode!=null) {
			System.out.println(finalNode.val);
			finalNode = finalNode.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0, carry=0, itemToAdd=0;
		ListNode finalNode = null, nextNode = null;
		//To avaoid finalNode null check add first number
		sum = l1.val + l2.val;
		itemToAdd = (sum % 10);
		carry = sum / 10;
		finalNode = new ListNode(itemToAdd);
		nextNode = finalNode;
		l1 = l1.next;
		l2 = l2.next;
		while(l1 !=null && l2 != null){
			sum = l1.val + l2.val + carry;
			itemToAdd = (sum % 10);
			carry = sum / 10;
			//System.out.println(itemToAdd);
			nextNode.next = new ListNode(itemToAdd);
			l1 = l1.next;
			l2 = l2.next;
			nextNode = nextNode.next;

		}
		// Add remaining nodes where list.next is not null
		if(l1!=null){
			sum = l1.val + carry;
			itemToAdd = (sum % 10);
			carry = sum / 10;
			//System.out.println(itemToAdd);
			nextNode.next = new ListNode(itemToAdd);
			l1 = l1.next;
			nextNode = nextNode.next;
			while(l1!=null){
				sum = l1.val + carry;
				itemToAdd = (sum % 10);
				carry = sum / 10;
				nextNode.next = new ListNode(itemToAdd);
				l1 = l1.next;
				nextNode = nextNode.next;
			}
		}else if(l2!=null){
			sum = l2.val + carry;
			itemToAdd = (sum % 10);
			carry = sum / 10;
			nextNode.next = new ListNode(itemToAdd);
			l2 = l2.next;
			nextNode = nextNode.next;
			while(l2!=null){
				sum = l2.val + carry;
				itemToAdd = (sum % 10);
				carry = sum / 10;
				nextNode.next = new ListNode(itemToAdd);
				l2 = l2.next;
				nextNode = nextNode.next;
			}
		}

		if(carry > 0){
			nextNode.next = new ListNode(carry);
		}
		return finalNode;
	}
	
	public static ListNode addTwoNumbersNew(ListNode l1, ListNode l2) {
		int carry=0;
		ListNode tempHead = new ListNode(0);
		ListNode head = tempHead;
		while(l1!=null || l2!=null) {
			//carry+=  (l1!=null ? l1.val : 0 )+ (l2!=null ? l2.val:0);
			if(l1!=null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if(l2!=null) {
				carry +=l2.val;
				l2= l2.next;
			}
			head.next= new ListNode(carry%10);
			head = head.next;
			carry = carry/10;
			
		}
		if(carry> 0) {
			head.next= new ListNode(carry);
		}
		
		return tempHead.next;
	}

}
