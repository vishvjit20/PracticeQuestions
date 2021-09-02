package DesignQuestions;


/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

public class BrowserHistory {
	
//	 String [] history = new String[50001];
//	 int curr, end;
//	 public BrowserHistory(String homepage) {
//		 history[0] = homepage;
//		 curr = 0;
//		 end = 0;
//	 }
//	    
//	 public void visit(String url) {
//		 if (history[curr] != url) {
//			 curr++;
//			 history[curr] = url;
//			 end = curr;
//		 }
//	 }
//	    
//	 public String back(int steps) {
//		 curr = Math.max(0, curr - steps);
//		 return history[curr];
//	 }
//	    
//	 public String forward(int steps) {
//		 curr = Math.min(end, curr + steps);
//		 return history[curr];
//	 }
	
	class Node {
		Node prev, next;
		String url;
		
		Node (String url) {
			prev = null;
			next = null;
			this.url = url;
		}
	}
	
	Node curr;
	public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        curr.next = node;
        node.prev = curr;
        curr = curr.next;
    }
    
    public String back(int steps) {
        while (curr.prev != null && steps-- > 0) {
        	curr = curr.prev;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while (curr.next != null && steps-- > 0) {
        	curr = curr.next;
        }
        return curr.url;
    }
}
