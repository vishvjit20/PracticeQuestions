package LikedList;

import java.util.*;

public class MergeSort {
	public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode merge2Lists(ListNode l1, ListNode l2) {
    	ListNode prev = new ListNode(-1);
    	ListNode curr = prev;
    	
    	ListNode p1 = l1;
    	ListNode p2 = l2;
    	
    	while (p1 != null && p2 != null) {
    		if (p1.val < p2.val) {
    			curr.next = p1;
    			p1 = p1.next;
    		}
    		else {
    			curr.next = p2;
    			p2 = p2.next;
    		}
    		curr = curr.next;
    	}
    	
    	if (p1 != null) curr.next = p1;
    	if (p2 != null) curr.next = p2;
    	
    	return prev.next;
    }
    
    public static ListNode mid(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while (fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	return slow;
    }

    public static ListNode mergeSort(ListNode head) {
    	if (head.next == null) {
    		return head;
    	}
    	ListNode mid = mid(head);
    	ListNode right = mid.next;
    	mid.next = null;
    	
    	ListNode l = mergeSort(head);
    	ListNode r = mergeSort(right);
    	
    	ListNode res = merge2Lists(l, r);
    	return res;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);

        ListNode head = mergeSort(h1);
        printList(head);
    }
}
