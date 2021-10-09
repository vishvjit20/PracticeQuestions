package LinkedListII;
import java.util.*;

public class CopyListWithRandomPointers {
	public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

// 	  public static Map<ListNode, ListNode> map = new HashMap<>();
//    public static ListNode copyRandomList(ListNode head) {
//        // copy values and next pointer
//    	ListNode dh = new ListNode(-1);
//    	ListNode dt = dh;
//    	
//    	ListNode temp = head;
//    	while (temp != null) {
//    		ListNode nn = new ListNode(temp.val);
//    		dt.next = nn;
//    		dt = nn;
//    		
//    		map.put(temp, nn);
//    		temp = temp.next;
//    	}
//    	
//    	// copy random pointers in new ll
//    	ListNode p1 = head;
//    	ListNode p2 = dh.next;
//    	
//    	while (p1 != null) {
//    		if (p1.random == null) p2.random = null;
//    		else {
//    			p2.random = map.get(p1.random);
//    		}
//    		p1 = p1.next;
//    		p2 = p2.next;
//    	}
//    	return dh.next;
//    }
	
	public static ListNode copyRandomList(ListNode head) {
		// 1. Insert new nodes b/w old nodes
		if (head == null) return head;
		ListNode curr = head;
		while (curr != null) {
			ListNode n = curr.next;
			ListNode nn = new ListNode(curr.val);
			curr.next = nn;
			nn.next = n;
		}
		// 2. set random pointers
		ListNode p1 = head;
		ListNode p2 = p1.next;
		
		while (p1 != null) {
			p2 = p1.next;
			if (p1.random == null) p2.random = null;
			else {
				p2.random = p1.random.next;
			}
			p1 = p1.next.next;
		}
		// 3. segregation
		ListNode cllh = head.next;
		
		ListNode h1 = head;
		ListNode h2 = cllh;
		while (h1 != null) {
			ListNode n1 = h2.next, n2 = null;
			if (n1 != null) n2 = n1.next;
			h1.next = n1;
			h2.next = n2;
			h1 = n1;
			h2 = n2;
		}
		return cllh;
	}

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}
