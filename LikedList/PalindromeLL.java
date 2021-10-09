package LikedList;

import java.util.*;

public class PalindromeLL {
	 public static class ListNode {
         int val = 0;
         ListNode next = null;
         ListNode(int val) {
             this.val = val;
         }
	 }
	 
	 public static boolean isPalindrome(ListNode head) {
		 ListNode slow = head;
		 ListNode fast = head;
		 
		 while (fast != null && fast.next != null) {
			 fast = fast.next.next;
			 slow = slow.next;
		 }
		 
		 if (fast != null) slow = slow.next;
		 slow = reverse(slow);
		 fast = head;
		 while (slow != null) {
			 if (fast.val != slow.val) {
				 return false;
			 }
			 slow = slow.next;
			 fast = fast.next;
		 }
		 return true;
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
	 
	 public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
	     int n = scn.nextInt();
         ListNode dummy = new ListNode(-1);
         ListNode prev = dummy;
         while (n-- > 0) {
         	 prev.next = new ListNode(scn.nextInt());
	         prev = prev.next;
	     }
	     System.out.println(isPalindrome(dummy.next));
	 }
}
