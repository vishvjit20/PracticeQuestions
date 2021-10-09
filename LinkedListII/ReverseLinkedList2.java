package LinkedListII;
import java.util.*;

public class ReverseLinkedList2 {
	public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseInRange(ListNode head, int left, int right) {
        ListNode temp = head;
        int pos = 1;
        
        ListNode p1 = null, p2 = null;
        ListNode ch = null, ct = null;
        
        while (temp != null) {
        	if (pos < left) {
        		p1 = temp;
        		temp = temp.next;
        	}
        	else if (pos >= left && pos <= right) {
        		ListNode node = temp.next;
        		temp.next = null;
        		
        		if (ch == null) {
        			ch = ct = temp;
        		}
        		else {
        			temp.next = ch;
        			ch = temp;
        		}
        		temp = node;
        	}
        	else {
        		p2 = temp;
        		break;
        	}
        	pos++;
        }
        if (p1 != null) {
        	p1.next = ch;
        	ct.next = p2;
        	return head;
        }
        else {
        	ct.next = p2;
        	return ch;
        }
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}
