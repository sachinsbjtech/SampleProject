package com.sbj.nonlinearDS;

public class SortedListToHeightBalancedBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) {
			return null;
		}
		return finalBST(head, null);
	}
	
	private TreeNode finalBST(ListNode head, ListNode tail) {
		if(head == tail) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast!=tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return new TreeNode(slow.val, finalBST(head, slow), finalBST(slow.next, tail));
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { 
			this.val = val; 
		}
		ListNode(int val, ListNode next) {
			this.val = val; this.next = next; 
		}
	}
}
