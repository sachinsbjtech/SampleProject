package com.sbj.practice;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		int array[] = {1,2,3,4,5};
		int i = 2;
		ListNode start = new ListNode(1);
		ListNode temp = start;
		while(i < 6) {
			temp.next = new ListNode(i);
			temp = temp.next;
			i++;
		}
		System.out.println(new ReverseNodesInKGroup().reverseKGroup(start, 2));
	}
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return head;
        }
        
        ListNode tempNode = head,start=null,newEnd=null,previousEnd=null, newHead=null;
        
        while(tempNode!=null){
        	int n = k;
            List<ListNode> list = new ArrayList();
            while(n>0 && tempNode!=null){
            	list.add(tempNode);
                tempNode = tempNode.next;
                n--;
            }
            newEnd = reverseList(list,start);
            //if remaining items are less that group size then return
            if(list.size() < k || newEnd == null){
                break;
            }
            // head after reversal
            if(newHead==null){
            	newHead = list.get(list.size()-1);
            }
            if(previousEnd!=null){
                previousEnd.next = start;
            }
            previousEnd = newEnd;
        }
        return newHead;
    }
    
    private ListNode reverseList(List<ListNode> list, ListNode start){
        int j= list.size()-1;
        if(j <1){
            return null;
        }
        ListNode temp = list.get(j);
        //already last node is stored in temp
        j--;
        while(j >= 0){
            temp.next = list.get(j);
            temp = temp.next;
            j--;
        }
        start = list.get(list.size()-1);
       
        // return item which will be last after reversing K group
        return list.get(0);
    }
}
