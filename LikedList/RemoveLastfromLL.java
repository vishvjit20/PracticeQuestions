package LikedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RemoveLastfromLL {
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
			  str = br.readLine();
		  }
	  }
}
