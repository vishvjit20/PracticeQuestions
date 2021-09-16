package Trie;

public class DesignAddAndSearchWord {
	public static class WordDictionary {
		private class Node {
			char c;
			boolean isEnd;
			Node[] children;
			public Node(char c) {
				this.c = c;
				children = new Node[26];
			}
			
			public boolean find(String word, int idx) {
				if (idx == word.length()) return isEnd;
				char c = word.charAt(idx);
				if (c == '.') {
					for (Node child : children) {
						if (child != null && child.find(word, idx + 1)) 
							return true;
					}
					return false;
				}
				else {
					if (children[c - 'a'] == null) return false;
					else return children[c - 'a'].find(word, idx + 1);
				}
			}
		}
		
		private Node root;
		public WordDictionary() {
			root = new Node('/');
		}
		
		public void addWord(String word) {
			Node curr = root;
			for (char c : word.toCharArray()) {
				if (curr.children[c - 'a'] == null)
				curr.children[c - 'a'] = new Node(c);
				curr = curr.children[c - 'a'];
			}
			curr.isEnd = true;
		}
		
		public boolean search(String word) {
			return root.find(word, 0);
		}		
	}
	public static void main(String args[]) {
		WordDictionary dict = new WordDictionary();
		dict.addWord("bad");
		dict.addWord("dad");
		dict.addWord("mad");
		System.out.println(dict.search("pad"));
		System.out.println(dict.search("bad"));
		System.out.println(dict.search(".ad"));
		System.out.println(dict.search("b.."));
	}
}
