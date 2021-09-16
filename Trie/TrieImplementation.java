package Trie;

public class TrieImplementation {
	public static class Trie {
		class Node {
			char c;
			boolean isWord;
			Node[] children;
			
			public Node(char c) {
				this.c = c;
				isWord = false;
				children = new Node[26];
			}
		}
		private Node root;
		public Trie() {
			root = new Node('/');
		}
		
		public void insert(String word) {
			Node curr = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (curr.children[c - 'a'] == null) {
					curr.children[c - 'a'] = new Node(c);
				}
				curr = curr.children[c - 'a'];
			}
			curr.isWord = true;
		}
		
		public boolean search(String word) {
			Node node = getNode(word);
			return node != null && node.isWord;
		}
		
		public boolean startsWith(String prefix) {
			return getNode(prefix) != null;
		}
		
		public Node getNode(String word) {
			Node curr = root;
			for (char c : word.toCharArray()) {
				if (curr.children[c - 'a'] == null) return null;
				curr = curr.children[c - 'a'];
			}
			return curr;
		}
	}
	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("black");
		trie.insert("car");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		System.out.println();
	}
}
