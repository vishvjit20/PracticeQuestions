package LikedList;

public class AddTwoLLs {
	public static class Node {
		int data;
		Node next;
	}
	public static class LinkedList {
		Node head, tail;
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
		
		public static int addListHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
			if (one == null && two == null) {
				return 0;
			}
			
			int data = 0;
			if (pv1 > pv2) {
				int oc = addListHelper(one.next, pv1 - 1, two, pv2, res);
				data = one.data + oc;
			}
			else if (pv2 > pv1) {
				int oc = addListHelper(one, pv1, two.next, pv2 - 1, res);
				data = two.data + oc;
			}
			else {
				int oc = addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
			    data = one.data + two.data + oc;
				
			}
			int nd = data % 10;
			int nc = data / 10;
			
			res.addFirst(nd);
			return nc;
		}
		
		public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
			LinkedList res = new LinkedList();
			
			int oc = addListHelper(one.head, one.size, two.head, two.size, res);
			if (oc > 0) res.addFirst(oc);
			return res;
		}
	}
	public static void main(String args[]) {
		int arr1[] = {9, 9 , 9 , 9};
		int arr2[] = {3, 4, 1};
		
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		for (int i = 0; i < arr1.length; i++) l1.addLast(arr1[i]);
		for (int i = 0; i < arr2.length; i++) l2.addLast(arr2[i]);
		
		LinkedList sum = LinkedList.addTwoLists(l1, l2);
		l1.display();
		l2.display();
		sum.display();
	}
}
