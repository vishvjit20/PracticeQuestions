package LikedList;

public class RemoveDuplicates {
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
		
		void removeFirst() {
			if (size == 0) System.out.println("List is empty");
			else if (size == 1) {
				head = tail = null;
				size = 0;
			}
			else {
				head = head.next;
				size--;
			}
		}
		
		int getFirst() {
			return head.data;
		}
		
		public void removeDuplicates() {
			LinkedList res = new LinkedList();
			
			while (this.size > 0) {
				int val = this.getFirst();
				this.removeFirst();
				
				if (res.size() == 0 || res.tail.data != val) {
					res.addLast(val);
				}
			}
			
			this.head = res.head;
			this.tail = res.tail;
			this.size = res.size;
		}
	}
	public static void main(String args[]) {
		
		int arr[] = {2, 2, 3, 3, 3, 3, 4, 5, 5, 6, 7, 8, 8};
		LinkedList ll = new LinkedList();
		for (int i = 0; i < arr.length; i++) ll.addLast(arr[i]);
		ll.display();
		ll.removeDuplicates();
		ll.display();
	}
}
