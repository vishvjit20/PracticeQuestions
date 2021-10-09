package LikedList;

import java.util.*;

public class MergeSortedLinkedList {
	public static Scanner sc = new Scanner(System.in);
	public static class ListNode {
		int data;
		ListNode next;
		ListNode(int data) {
			this.data = data;
		}
	}
	
	// tc O(n + m)
	// sc O(1)
	public static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
		ListNode prev = new ListNode(-1);
		ListNode curr = prev;
		
		ListNode p1 = l1;
		ListNode p2 = l2;
		
		while (p1 != null && p2 != null) {
			if (p1.data < p2.data) {
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
	
	public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
	
	public static ListNode createList(int n) {
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while (n-- > 0) {
			prev.next = new ListNode(sc.nextInt());
			prev = prev.next;
		}
		return dummy.next;
	}
	
	public static void main(String args[]) {
		int n = sc.nextInt();
		ListNode n1 = createList(n);
		int m = sc.nextInt();
		ListNode n2 = createList(m);
		
		ListNode head = mergeSortedLists(n1, n2);
		printList(head);
	}
}
