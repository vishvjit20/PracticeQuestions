package LikedList;

public class MergeSortOfLL {
	public static class Node {
		int data;
		Node next;
	}
	public static class LinkedList {
		Node head, tail;
		int size;
		
		int size() {
			return size;
		}
		
		void display() {
			for (Node node = head; node != null; node = node.next) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
		
		void addLast(int val) {
			Node node = new Node();
			node.data = val;
			node.next = null;
			
			if (size == 0) head = tail = node;
			else {
				tail.next = node;
				tail = node;
			}
			size++;
		}
		public static LinkedList mergeTwoSortedLL(LinkedList l1, LinkedList l2) {
			Node one = l1.head;
			Node two = l2.head;
			
			LinkedList res = new LinkedList();
			
			while (one != null && two != null) {
				if (one.data < two.data) {
					res.addLast(one.data);
					one = one.next;
				}
				else {
					res.addLast(two.data);
					two = two.next;
				}
			}
			while (one != null) {
				res.addLast(one.data);
				one = one.next;
			}
			while (two != null) {
				res.addLast(two.data);
				two = two.next;
			}
			
			return res;
		}
		public static Node mid (Node head, Node tail) {
			Node slow = head;
			Node fast = head;
			
			while (fast != tail && fast.next != tail) {
				fast = fast.next.next;
				slow = slow.next;
			}
			
			return slow;
		}
		public static LinkedList mergeSort(Node head, Node tail) {
			if (head == tail) {
				LinkedList ll = new LinkedList();
				ll.addLast(head.data);
				return ll;
			}
			Node mid = mid(head, tail);
			LinkedList left =  mergeSort(head, mid);
			LinkedList right = mergeSort(mid.next, tail);
			LinkedList res = LinkedList.mergeTwoSortedLL(left, right);
			
			return res;
		}
		
	}
	
	public static void main(String args[]) {
		
		int arr[] = {71, 89, 5, 15, 3, 463, 441, 48, 520, 96};
		
		LinkedList ll = new LinkedList();
		
		for (int i = 0 ; i < arr.length; i++) ll.addLast(arr[i]);
		
		LinkedList sorted = LinkedList.mergeSort(ll.head, ll.tail);
		sorted.display();
		ll.display();
	}
}
