package Stack;
import java.io.*;
import java.util.*;

public class MinStack2 {
	public static class MinStack {
		Stack<Integer> data;
	    int min;

	    public MinStack() {
	    	data = new Stack<>();
	    	min = Integer.MAX_VALUE;
	    }

	    int size() {
	    	return data.size();
	    }

	    void push(int val) {
	    	if (data.size() == 0) {
	    		data.push(val);
	    		min = val;
	    	}
	    	else {
	    		if (val > min) data.push(val);
	    		else {
	    			min = val;
	    			data.push(val + val - min);
	    		}
	    	}
	    }

	    int pop() {
	    	if (data.size() == 0) return -1;
	    	else {
	    		if (data.peek() > min) return data.pop();
	    		else {
	    			int val = data.pop();
	    			min = 2 * min - val;
	    			return val;
	    		}
	    	}
	    }

	    int top() {
	    	int val = data.peek();
	    	if (val > min) return val;
	    	return min;
	    }

	    int min() {
	    	return min;
	    }
	  }

	  public static void main(String[] args) throws Exception {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  MinStack st = new MinStack();

		  String str = br.readLine();
		  while (str.equals("quit") == false) {
			  if (str.startsWith("push")) {
				  int val = Integer.parseInt(str.split(" ")[1]);
				  st.push(val);
			  } 
			  else if (str.startsWith("pop")) {
				  int val = st.pop();
				  if (val != -1)	System.out.println(val);
			  } 
			  else if (str.startsWith("top")) {
				  int val = st.top();
				  if (val != -1)	System.out.println(val);
			  }	 
			  else if (str.startsWith("size"))	System.out.println(st.size());
			  else if (str.startsWith("min")) {
				  int val = st.min();
				  if (val != -1)	System.out.println(val);
			  }
			  str = br.readLine();
		  }
	  }
}
