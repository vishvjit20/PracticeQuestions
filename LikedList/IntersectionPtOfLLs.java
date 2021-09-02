package LikedList;

public class IntersectionPtOfLLs {

	public static class Node {
		int data;
		Node next;
	}
	public static class LinkedList {
		Node head, tail;
		int size;
		
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
			
			if (size == 0) {
				head = tail = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			size++;
		}
		public static int findIntersection(LinkedList l1, LinkedList l2) {
			Node t1 = l1.head;
			Node t2 = l2.head;
			
			int delta = Math.abs(l1.size - l2.size);
			if (l1.size > l2.size) {
				for (int i = 0; i < delta; i++) t1 = t1.next;
			}
			else {
				for (int i = 0; i < delta; i++) t2 = t2.next;
			}
			
			while (t1 != t2) {
				t1 = t1.next;
				t2 = t2.next;
			}
			return t2.data;
		}
	}
	public static void main(String[] args) {
		int arr1[] = {5, 9, 9, 8, 11, 15, 4, 7};
		int arr2[] = {3, 5, 15, 4, 7};
		
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		for (int i = 0; i < arr1.length; i++) l1.addLast(arr1[i]);
		for (int i = 0; i < arr2.length; i++) l2.addLast(arr2[i]);
		
		l1.display();
		l2.display();
		System.out.println(LinkedList.findIntersection(l1, l2));
	}

}
