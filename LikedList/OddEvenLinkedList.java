package LikedList;

public class OddEvenLinkedList {
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
			Node node;
			for (node = head; node.next != null; node = node.next) {
				System.out.print(node.data + " -> ");
			}
			System.out.print(node.data);
			System.out.println();
		}
		
		void addLast(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = null;
			
			if (size == 0) head = tail = temp;
			else {
				tail.next = temp;
				tail = temp;
			}
			
			size++;
		}
		
		int getFirst() {
			return head.data;
		}
		
		void removeFirst() {
			if (size == 0) {
				System.out.println("List is empty");
			}
			else if (size == 1) {
				head = tail = null;
				size = 0;
			}
			else {
				head = head.next;
				size--;
			}
		}
		
		void oddEvenLL () {
			LinkedList odd = new LinkedList();
			LinkedList even = new LinkedList();
			
			while (this.size > 0) {
				int val = this.getFirst();
				this.removeFirst();
				
				if (val % 2 == 0) even.addLast(val);
				else odd.addLast(val);
			}
			
			if (odd.size > 0 && even.size > 0) {
				odd.tail.next = even.head;
				this.head = odd.head;
				this.tail = even.tail;
				this.size = odd.size + even.size;
			}
			else if (odd.size > 0) {
				this.head = odd.head;
				this.tail = odd.tail;
				this.size = odd.size;
			}
			else if (even.size > 0) {
				this.head = even.head;
				this.tail = even.tail;
				this.size = even.size;
			}
		}
	}
	
	public static void main(String args[]) {
		int arr[] = {2, 8, 9, 1, 5, 4, 3};
		LinkedList ll = new LinkedList();
		for (int i = 0; i < arr.length; i++) ll.addLast(arr[i]);
		ll.display();
		ll.oddEvenLL();
		ll.display();
	}
	
}
