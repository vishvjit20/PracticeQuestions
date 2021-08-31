package LikedList;
import java.io.*;

public class RemoveFirstFromLL {
	public static class Node {
		int data;
		Node next;
	}
	public static class LinkedList {
		Node head, tail;
		int size;
		
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
		
		int size() {
			return size;
		}
		
		void display () {
			for (Node node = head; node != null; node = node.next) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		LinkedList list = new LinkedList();
		
		while (!str.equals("quit")) {
			if (str.startsWith("addLast")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				list.addLast(val);
			}
			else if (str.startsWith("size")) {
				System.out.println(list.size());
			}
			else if (str.startsWith("display")) {
				list.display();
			}
			else if (str.startsWith("removeFirst")) {
		        list.removeFirst();
		    } 
		    str = br.readLine();
		}
	}
}
