package LikedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseALinkedList {
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
		
		void addFirst(int val) {
			Node node = new Node();
			node.data = val;
			node.next = head;
			head = node;
			
			if (size == 0) tail = node;
			
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
		
		void removeLast() {
			if (size == 0) {
				System.out.println("List is empty");
			}
			else if (size == 1) {
				head = tail = null;
				size = 0;
			}
			else {
				Node temp = head;
				for (int i = 0; i < size - 2; i++) {
					temp = temp.next;
				}
				tail = temp;
				temp.next = null;
				size--;
			}
		}
		
		void removeAt(int idx) {
			if (idx < 0 || idx >= size) {
				System.out.println("Invalid arguments");
			}
			else if (idx == 0) removeFirst();
			else if (idx == size - 1) removeLast();
			else {
				Node temp = head;
				for (int i = 0; i < idx - 1; i++) {
					temp = temp.next;
				}
				temp.next = temp.next.next;
				size--;
			}
		}
		
		int getFirst() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			}
			else {
				return head.data;
			}
		}
		
		int getLast() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			}
			return tail.data;
		}

		int getAt(int idx) {
			if (idx < 0 || idx >= size) {
				System.out.println("Invalid arguments");
				return -1;
			}
			else {
				Node temp = head;
				for (int i = 0; i < idx; i++) {
					temp = temp.next;
				}
				return temp.data;
			}
		}
		
		void addAt(int idx, int val) {
			Node node = new Node();
			node.data = val;
			
			Node temp = head;
			for (int i = 0; i < idx - 1; i++) {
				temp = temp.next;
			}
			node.next = temp.next;
			temp.next = node;
			
			size++;
		}
	
		void display() {
			for (Node node = head; node != null; node = node.next) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	
		private Node getNodeAt(int idx) {
			Node node = head;
			for (int i = 0 ; i < idx; i++) {
				node = node.next;
			}
			return node;
		}
		
		void reverseDI() {
			int li = 0;
			int ri = size - 1;
			while (li < ri) {
				Node n1 = getNodeAt(li);
				Node n2 = getNodeAt(ri);
				
				int temp = n1.data;
				n1.data = n2.data;
				n2.data = temp;
				
				li++;
				ri--;
			}
		}
		
		void reversePI() {
			Node prev = null, curr = head;
			
			while (curr != null) {
				Node next = curr.next;
				curr.next = prev;
				prev =  curr;
				curr = next;
			}
			
			Node temp = head;
			head = tail; 
			tail = temp;
		}
		
		void reverseDRHelper(Node node, int floor) {
			if (node == null) return;
			reverseDRHelper(node.next, floor + 1);
			
			if (floor > size / 2) {
				int temp = node.data;
				node.data = left.data;
				left.data = temp;
				left = left.next;
			}
		}
		
		Node left;
		void reverseDR() {
			left = head;
			reverseDRHelper(head, 0);
		}

		void reversePRHelper(Node node) {
			if (node == null) return;
			
			reversePRHelper(node.next);
			
			if (node != tail) node.next.next = node;
		}
		
		void reversePR() {
			
			reversePRHelper(head);
			
			head.next = null;
			Node temp = head;
			head = tail;
			tail = temp;
		}
	}
	
	public static void main(String[] args) throws Exception {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  LinkedList list = new LinkedList();

		  String str = br.readLine();
		  while (str.equals("quit") == false) {
			  if (str.startsWith("addLast")) {
				  int val = Integer.parseInt(str.split(" ")[1]);
				  list.addLast(val);
			  } 
			  else if (str.startsWith("size")) System.out.println(list.size());
			  else if (str.startsWith("display")) list.display();
			  else if (str.startsWith("removeFirst")) list.removeFirst();
			  else if (str.startsWith("removeLast")) list.removeLast();
			  else if (str.startsWith("getFirst")) {
				  int val = list.getFirst();
				  if (val != -1) {
					  System.out.println(val);
				  }
			  } 
			  else if (str.startsWith("getLast")) {
				  int val = list.getLast();
				  if (val != -1) {
					  System.out.println(val);
				  }
			  } 
			  else if (str.startsWith("getAt")) {
				  int idx = Integer.parseInt(str.split(" ")[1]);
				  int val = list.getAt(idx);
				  if (val != -1) {
					  System.out.println(val);
				  }
			  } 
			  else if (str.startsWith("addFirst")) {
				  int val = Integer.parseInt(str.split(" ")[1]);
				  list.addFirst(val);
			  }
			  else if (str.startsWith("addLast")) {
				  int val = Integer.parseInt(str.split(" ")[1]);
				  list.addLast(val);
			  }
			  else if (str.startsWith("addAt")) {
			        int idx = Integer.parseInt(str.split(" ")[1]);
			        int val = Integer.parseInt(str.split(" ")[2]);
			        list.addAt(idx, val);
			  }
			  else if (str.startsWith("removeAt")) {
			        int idx = Integer.parseInt(str.split(" ")[1]);
			        list.removeAt(idx);
			  } 
			  else if (str.startsWith("reverseDI")) list.reverseDI();
			  else if (str.startsWith("reversePI")) list.reversePI();
			  str = br.readLine();
		  }
	  }
}
