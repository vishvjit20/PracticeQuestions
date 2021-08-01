package HashMapNHeap;
import java.util.*;

public class HashMapImplementation {
	public static class HMap<K, V> {
		private class HMNode {
			K key;
			V value;
			
			HMNode (K key, V value) {
				this.key = key;
				this.value = value;
			}
		}
		private int size;
		private LinkedList<HMNode> []buckets;
		
		public HMap() {
			initBuckets(4);
			size = 0;
		}
		
		private void initBuckets(int N) {
			buckets = new LinkedList[N];
			for (int i = 0; i < N; i++) {
				buckets[i] = new LinkedList<>();
			}
		}
		
		public void put(K key, V value) {
			int bi = findBucketIdx(key);
			int di = findWithinBucket(key, bi);
			
			if (di == -1) {
				LinkedList<HMNode> list = buckets[bi];
				HMNode node = new HMNode(key, value);
				list.add(node);
				size++;
			}
			else {
				LinkedList <HMNode> list = buckets[bi];
				HMNode node = list.get(di);
				node.value = value;
			}
			
			double lambda = size*1.0 / buckets.length;
			if (lambda > 2) rehash();
		}
		
		private void rehash() {
			LinkedList <HMNode> oldBuckets[] = buckets;
			initBuckets(2 * oldBuckets.length);
			size = 0;
			
			for (int bi = 0; bi < oldBuckets.length; bi++) {
				for (int i = 0; i < oldBuckets[bi].size(); i++) {
					HMNode node = oldBuckets[bi].get(i);
					put(node.key, node.value);
				}
			}
		}
		
		private int findBucketIdx(K key) {
			int hash_code = key.hashCode();
			int bi = Math.abs(hash_code) % buckets.length;
			return bi;
		}
		
		private int findWithinBucket(K key, int bi) {
			LinkedList<HMNode> list = buckets[bi];
			for (int i = 0; i < list.size(); i++) {
				HMNode node = list.get(i);
				if (key.equals(node.key))
					return i;
			}
			return -1;
		}
		
		private V get(K key) {
			int bi = findBucketIdx(key);
			int di = findWithinBucket(key, bi);
			
			if (di == -1) return null;
			else {
				LinkedList<HMNode> list = buckets[bi];
				HMNode node = list.get(di);
				return node.value;
			}
		}
		
		public boolean containsKey(K key) {
			int bi = findBucketIdx(key);
			int di = findWithinBucket(key, bi);
			
			if (di == -1) return false;
			else return true;
		}
		
		public V remove(K key) {
			int bi = findBucketIdx(key);
			int di = findWithinBucket(key, bi);
			
			if (di == -1) {
				return null;
			}
			else {
				LinkedList <HMNode> list = buckets[bi];
				HMNode node = list.get(di);
				V val = node.value;
				list.remove(di);
				size--;
				return val;
			}
		}

		public ArrayList<K> keyset() {
			ArrayList<K> keys = new ArrayList<>();
			for (int i = 0; i < buckets.length; i++) {
				for (int j = 0; j < buckets[i].size(); j++) {
					HMNode node = buckets[i].get(j);
					keys.add(node.key);
				}
			}
			return keys;
		}
		
		public int size() {
			return size;
		}
		
		public void display() {
			System.out.println("Display Begins");
			for (int i = 0; i < buckets.length; i++) {
				System.out.print("Bucket " + i + " ");
				for (HMNode node : buckets[i]) {
					System.out.print(node.key + "@" + node.value + " ");
				}
				System.out.println();
			}
			System.out.println("Display Ends");
		}
		
		public static void main(String args[]) {
			HMap<String, Integer> map = new HMap<>();
			map.put("India", 115);	
			map.put("Nigeria", 91);
			map.put("England", 73);
			map.put("USA", 55);
			map.put("Canada", 5);
			map.put("China", 112);
			map.put("Pakistan", 55);
			map.put("Brazil", 87);
			map.put("Nepal", 4);
			map.put("China", 99);
			
			map.display();
			
			System.out.println(map.containsKey("Bhutan"));
			System.out.println(map.containsKey("India"));
			
			System.out.println(map.get("China"));
			System.out.println(map.get("England"));
			System.out.println(map.get("SriLanka"));
			
			map.remove("Nigeria");
			map.remove("Pakistan");
			
			map.display();
			for (String key : map.keyset()) {
				System.out.println(key);
			}
		}
		
	}
}