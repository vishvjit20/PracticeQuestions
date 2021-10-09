package LinkedListII;
import java.util.*;

public class IntersectionNode {
	public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static int size(ListNode node) {
    	int cnt = 0;
    	while (node != null) {
    		cnt++;
    		node = node.next;
    	}
    	return cnt;
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
    	int l1 = size(headA);
    	int l2 = size(headB);
    	
    	int diff = Math.abs(l1 - l2);
    	if (diff != 0) {
    		if (l1 > l2) while (l1 != l2) {
    			headA = headA.next;
    			l1--;
    		}
    		else while (l1 != l2) {
    			headB = headB.next;
    			l2--;
    		}
    	}
    	
    	while (headA != headB && headA != null) {
			headA = headA.next;
			headB = headB.next;
		}
    	if (headA == null) return null;
    	return headA;
    	
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

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}
