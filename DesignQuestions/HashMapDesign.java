package DesignQuestions;

import java.util.*;

public class HashMapDesign {
	public static class HMap<K, V> {
		private class HMNode {
			K key;
			V value;
			
			public HMNode(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}
		
		private int size;
		private LinkedList<HMNode> buckets[];
		private void initBuckets(int N) {
			buckets = new LinkedList[N];
			for (int i = 0; i < N; i++) {
				buckets[i] = new LinkedList<>();
			}
		}
		
		public HMap() {
			initBuckets(4);
			size = 0;
		}
		
		private int findBucketIndex(K key) {
			int hash_code = key.hashCode();
			int idx = Math.abs(hash_code) % buckets.length;
			return idx;
		}
		
		private int findWithInBucket(K key, int bucketIdx) {
			LinkedList<HMNode> list = buckets[bucketIdx];
			for (int i = 0; i < list.size(); i++) {
				if (key == list.get(i).key) {
					return i;
				}
			}
			return -1;
		}
		
		public void put(K key, V value) {
			int bucketIdx = findBucketIndex(key);
			int dataIdx = findWithInBucket(key, bucketIdx);
			
			LinkedList<HMNode> list = buckets[bucketIdx];
			if (dataIdx == -1) {
				HMNode node = new HMNode(key, value);
				list.add(node);
				size++;
			}
			else {
				HMNode node = list.get(dataIdx);
			    node.value = value;
			}
			
			double lambda = size * 1.0 / buckets.length;
			if (lambda > 2) rehash();
		}
		
		private void rehash() {
			LinkedList<HMNode> oldBuckets[] = buckets;
			initBuckets(2 * oldBuckets.length);
			size = 0;
			for (int i = 0; i < oldBuckets.length; i++) {
				for (HMNode node : oldBuckets[i]) {
					put(node.key, node.value);
				}
			}
		}
		
		public V get(K key) {
			int bucketIdx = findBucketIndex(key);
			int dataIdx = findWithInBucket(key, bucketIdx);
			
			if (dataIdx == -1) return null;
			else {
				LinkedList<HMNode> list = buckets[dataIdx];
				HMNode node = list.get(dataIdx);
				return node.value;
			}
		}
		
		public boolean containsKey(K key) {
			int bucketIdx = findBucketIndex(key);
			int dataIdx = findWithInBucket(key, bucketIdx);
			
			if (dataIdx == -1) return false;
			return true;
		}
		
		public V remove(K key) {
			int bucketIdx = findBucketIndex(key);
			int dataIdx = findWithInBucket(key, bucketIdx);
			
			if (dataIdx == -1) return null;
			else {
				LinkedList<HMNode> list = buckets[bucketIdx];
				HMNode node = list.get(dataIdx);
				list.remove(dataIdx);
				size--;
				return node.value;
			}
		}
		
		public ArrayList<K> keySet() {
			ArrayList<K> keys = new ArrayList<>();
			
			for (int i = 0; i < buckets.length; i++) {
				for (HMNode node : buckets[i]) {
					keys.add(node.key);
				}
			}
			return keys;
		}
		
		public int size() {
			return size;
		}
		
		public void display() {
			System.out.println("__________________________________");
			
			for (int i = 0; i < buckets.length; i++) {
				System.out.print(i + ". ");
				for (HMNode node : buckets[i]) {
					System.out.print(node.key + " - " + node.value + ", ");
				}
				System.out.println();
			}
			
			System.out.println("__________________________________");
		}
	}
	
	public static void main(String args[]) {
		HMap<String, Integer> map = new HMap<>(); 
		map.put("India", 35);
		map.put("China", 17);
		map.put("Canada", 18);
		map.put("Nigeria", 115);
		map.put("Tokyo", 97);
		map.put("USA", 73);
		map.put("Germany", 81);
		map.put("Nepal", 125);
		map.put("India", 88);
		map.put("Vietnam", 11);
		map.display();
		map.remove("Korea");
		map.remove("Nigeria");
		map.remove("Nepal");
		map.display();
		ArrayList<String> keys = map.keySet();
		System.out.println(keys);
		System.out.println(map.containsKey("Korea"));
		System.out.println(map.containsKey("China"));
	}
}
