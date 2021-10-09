package LinkedListII;

import java.util.*;

import DesignQuestions.LRUCache.Node;
public class LRUCache {
	public static class Node {
		int key;
		int val;
		Node prev;
		Node next;
		
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
		
	public static Map<Integer, Node> map = new HashMap<>();
		
	public static int capacity = 0;
	public static Node first;
	public static Node last;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		first = new Node(0, 0);
		last = new Node(0, 0);
		first.next = last;
		last.prev = first;
	}
	
	public static int get(int key) {
		Node node = map.get(key);
		if (node == null) return -1;
		remove(node);
		insert(node);
		return node.val;
	}
	
	public static void put(int key, int val) {
		if (map.containsKey(key)) {
			map.remove(key);
		}
		if (map.size() == capacity) {
			remove(last.prev);
		}
		insert(new Node(key, val));
	}
		
	public static void insert(Node node) {
		map.put(node.key, node);
		first.next.prev = node;
		node.next = first.next;
		node.prev = first;
		first.next = node;
	}
		
	public static void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.prev = null;
		node.next = null;
	}
	
	public static void display() {
		for (Node node = first.next; node != last; node = node.next) {
			System.out.print(node.key + " - " + node.val);
			if (node.next != last) System.out.print(", ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		LRUCache cache = new LRUCache(5);
		cache.put(1, 2);
		display();
		cache.put(2, 3);
		display();
		cache.put(5, 9);
		display();
		cache.put(4, 8);
		display();
		cache.get(5);
		display();
		cache.put(4, 11);
		display();
		cache.put(3, 4);
		display();
		cache.put(8, 7);
		display();
		cache.put(15, 7);
		display();
		cache.get(3);
		display();
	}
}
