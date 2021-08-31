package LikedList;

public class Merge2SortedLL {
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
		
	}
	
	public static void main(String args[]) {
		int arr1[] = {10, 20, 30, 40, 50};
		int arr2[] = {7, 9, 12, 15, 37, 43, 44, 48, 52, 56};
		
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		for (int i = 0 ; i < arr1.length; i++) l1.addLast(arr1[i]);
		for (int i = 0 ; i < arr2.length; i++) l2.addLast(arr2[i]);
		
		LinkedList merged = LinkedList.mergeTwoSortedLL(l1, l2);
		merged.display();
		l1.display();
		l2.display();
	}
}
