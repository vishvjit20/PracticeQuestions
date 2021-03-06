package LikedList;

public class FoldALL {
	public static class Node {
		int data;
		Node next;
	}
	public static class LinkedList {
		Node head;
		  Node tail;
		  int size;

		  void addLast(int val) {
			  Node temp = new Node();
			  temp.data = val;
			  temp.next = null;

			  if (size == 0) {
				  head = tail = temp;
			  } else {
				  tail.next = temp;
				  tail = temp;
			  }
			  size++;
		  }

		  public int size() {
			  return size;
		  }

		  public void display() {
			  for (Node temp = head; temp != null; temp = temp.next) {
				  System.out.print(temp.data + " ");
			  }
			  System.out.println();
		  }

		  public void removeFirst() {
			  if (size == 0) {
				  System.out.println("List is empty");
			  } else if (size == 1) {
				  head = tail = null;
				  size = 0;
			  } else {
				  head = head.next;
				  size--;
			  }
		  }

		  public int getFirst() {
			  if (size == 0) {
				  System.out.println("List is empty");
				  return -1;
			  } else {
				  return head.data;
			  }
		  }

		  public int getLast() {
			  if (size == 0) {
				  System.out.println("List is empty");
				  return -1;
			  } else {
				  return tail.data;
			  }
		  }

		  public int getAt(int idx) {
			  if (size == 0) {
				  System.out.println("List is empty");
				  return -1;
			  } else if (idx < 0 || idx >= size) {
				  System.out.println("Invalid arguments");
				  return -1;
			  } else {
				  Node temp = head;
				  for (int i = 0; i < idx; i++) {
					  temp = temp.next;
				  }
				  return temp.data;
			  }
		  }

		  public void addFirst(int val) {
			  Node node = new Node();
			  node.data = val;
			  node.next = head;
			  head = node;
	    	
			  if (size == 0) {
				  tail = node;
			  }
	    	
			  size++;
		  }

		  public void foldHelper(Node node, int floor) {
			  if (node == null) return;
			  foldHelper(node.next, floor + 1);
			  
			  if (floor > size / 2) {
				  Node temp = left.next;
				  left.next = node;
				  node.next = temp;
				  left = temp;
			  }
			  else if (floor == size / 2) {
				  tail = node;
				  tail.next = null;
			  }
			  
		  }
		  
		  Node left;
		  public void fold() {
			  left = head;
			  foldHelper(head, 0);
		  }
	
	}
	public static void main(String args[]) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		LinkedList ll = new LinkedList();
		for (int i = 0; i < arr.length; i++) ll.addLast(arr[i]);
		
		ll.display();
		ll.fold();
		ll.display();
	}
}
