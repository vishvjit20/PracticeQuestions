package LinkedListII;

import LinkedListII.CopyListWithRandomPointers.ListNode;

public class AddTwoLL {
	public static ListNode reverse(ListNode curr) {
		ListNode prev = null;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = curr.next;
		}
		
		return prev;
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode t1 = reverse(l1);
		ListNode t2 = reverse(l2);
		
		int carry = 0;
		ListNode dummyH = new ListNode(-1);
		ListNode dummyT = dummyH;
		
		while (t1 != null || t2 != null || carry != 0) {
			int sum = carry;
			if (t1 != null) {
				sum += t1.val;
				t1 = t1.next;
			}
			if (t2 != null) {
				sum += t2.val;
				t2 = t2.next;
			}
			
			int val = sum % 10;
			carry = sum / 10;
			
			ListNode res = new ListNode(val);
			dummyT.next = res;
			dummyT = dummyT.next;
		}
		
		ListNode ans = reverse(dummyH.next);
		return ans;
	}
}
