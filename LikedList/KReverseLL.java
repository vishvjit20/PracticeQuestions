package LikedList;

public class KReverseLL {

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
		
		void addFirst(int val) {
			Node node = new Node();
			node.data = val;
			node.next = head;
			head = node;
			if (size == 0) {
				tail = node;
			}
			
			size++;
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
		
		int getFirst() {
			return head.data;
		}
		
		void kReverse(int k) {
			LinkedList prev = null;
			
			while (this.size() > 0) {
				LinkedList curr = new LinkedList();
				
				if (this.size >= k) {
					for (int i = 0; i < k; i++) {
						int val = this.getFirst();
						this.removeFirst();
						curr.addFirst(val);
					}
				}
				else {
					int newSize = this.size();
					for (int i = 0; i < newSize; i++) {
						int val = this.getFirst();
						this.removeFirst();
						curr.addLast(val);
					}
				}
				if (prev == null) prev = curr;
				else {
					prev.tail.next = curr.head;
					prev.tail = curr.tail;
					prev.size += curr.size;
				}
			}
			this.head = prev.head;
			this.tail = prev.tail;
			this.size = prev.size;
		}
	}
	
	public static void main(String args[]) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		
		LinkedList ll = new LinkedList();
		for (int i = 0; i < arr.length; i++) ll.addLast(arr[i]);
		
		ll.display();
		ll.kReverse(3);
		ll.display();
	}
}
