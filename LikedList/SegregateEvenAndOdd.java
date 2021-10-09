package LikedList;
import java.util.*;

public class SegregateEvenAndOdd {
	public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
    	ListNode eH = new ListNode(-1);
    	ListNode eT = eH;
    	ListNode oH = new ListNode(-1);
    	ListNode oT = oH;
    	
    	ListNode temp = head;
    	
    	while (temp != null) {
    		if (temp.val % 2 == 0) {
    			eT.next = temp;
    			eT = eT.next;
    		}
    		else {
    			oT.next = temp;
    			oT = oT.next;
    		}
    		temp = temp.next;
    	}
    	oT.next = null;
    	eT.next = oH.next;
    	return eH.next;	
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

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
