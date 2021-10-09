package LinkedListII;

import java.util.*;

public class RemoveDuplicate2 {
	public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
        
    }
    
    public static ListNode removeDuplicates(ListNode head) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode curr = dummy;
    	
    	while (head != null) {
    		if (head.next != null && head.val == head.next.val) {
    			while (head.next != null && head.val == head.next.val) head = head.next;
    			curr.next = head.next;
    		}
    		else curr = curr.next;
    		head = head.next;
    	}
    	return dummy.next;
    }
    
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }
}
