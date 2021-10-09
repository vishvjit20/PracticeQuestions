package LinkedListII;
import java.util.*;


public class Subtract2LL {
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
	    int val = 0;
	    ListNode next = null;
	    ListNode(int val) {
	      this.val = val;
	    }
	}
	  
	public static ListNode reverse(ListNode curr) {
		ListNode prev = null;
		while (curr != null) {
			ListNode next =  curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	public static int length(ListNode node) {
		int count = 0;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}
	
	public static int compare(ListNode l1, ListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		
		if (len1 > len2) return 1;
		else if (len2 > len1) return -1;
		else {
			ListNode t1 = l1, t2 = l2;
			
			while (t1 != null && t2 != null) {
				if (t1.val > t2.val) return 1;
				else if (t1.val < t2.val) return -1;
				else {
					t1 = t1.next;
					t2 = t2.next;
				}
			}
		}
		return 0;
	}
	
	public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
		ListNode t1 = null, t2 = null;
		int compare = compare(l1, l2);
		if(compare == 0) return new ListNode(0);
		else if (compare == 1) {
//			l1 > l2
			t1 = reverse(l1);
			t2 = reverse(l2);
		}
		else {
			t1 = reverse(l2);
			t2 = reverse(l1);
		}
		
		int borrow = 0;
		ListNode dH = new ListNode(-1);
		ListNode dT = dH;
		while (t1 != null) {
			int sub = t1.val + borrow;
			if (t2 != null) {
				sub -= t2.val;
				t2 = t2.next;
			}
			
			if (sub < 0) {
				sub += 10;
				borrow = -1;
			}
			
			else borrow = 0;
			
			ListNode node = new ListNode(sub);
			dT.next = node;
			dT = dT.next;
			t1 = t1.next;
		}
		ListNode ans = reverse(dH.next);
		
		// shifting head
		while (ans != null && ans.val == 0) ans = ans.next;
		return ans;
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
	    ListNode head1 = makeList(scn.nextInt());
	    ListNode head2 = makeList(scn.nextInt());

	    ListNode ans = subtractTwoNumbers(head1, head2);
	    printList(ans);
	}
}
