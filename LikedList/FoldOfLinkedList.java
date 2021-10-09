package LikedList;
import java.util.*;


public class FoldOfLinkedList {
	public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void fold(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while (fast.next != null && fast.next.next != null) {
    		fast = fast.next.next;
			slow = slow.next;
		}
		 
	    slow = reverse(slow);
		fast = head;
    	
    	while (fast != null) {
    		ListNode left = fast.next;
    		ListNode right = slow.next;
    		
    		fast.next = slow;
    		slow.next = left;
    		
    		fast = left;
    		slow = right;
    	}
    	
    }
    
    public static ListNode reverse(ListNode curr) {
    	ListNode prev = null;
		 while (curr != null) {
			 ListNode next = curr.next;
			 curr.next = prev;
			 prev = curr;
			 curr = next;
		 }
		 
		 return prev;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}
