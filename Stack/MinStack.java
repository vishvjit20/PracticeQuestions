package Stack;
import java.io.*;
import java.util.*;

public class MinStack {
	public static class MinStk {
		Stack<Integer> allData;
		Stack<Integer> minData;
		
		MinStk() {
			allData = new Stack<>();
			minData = new Stack<>();
		}
		
		int size() {
			return allData.size();
		}
		
		void push(int val) {
			if (allData.size() == 0) {
				allData.push(val);
				minData.push(val);
			}
			else {
				allData.push(val);
				if (allData.peek() <= minData.peek()) {
					minData.push(val);
				}
			}
		}
		
		int pop() {
			int val = allData.pop();
			if (minData.peek() == val) minData.pop();
			return val;
		}
		
		int top() {
			return allData.peek();
		}
		
		int min() {
			return minData.peek();
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    MinStk st = new MinStk();

	    String str = br.readLine();
	    
	    while(str.equals("quit") == false) {
	    	if(str.startsWith("push")){
	            int val = Integer.parseInt(str.split(" ")[1]);
	            st.push(val);
	          } else if(str.startsWith("pop")){
	            int val = st.pop();
	            if(val != -1){
	              System.out.println(val);
	            }
	          } else if(str.startsWith("top")){
	            int val = st.top();
	            if(val != -1){
	              System.out.println(val);
	            }
	          } else if(str.startsWith("size")){
	            System.out.println(st.size());
	          } else if(str.startsWith("min")){
	            int val = st.min();
	            if(val != -1){
	              System.out.println(val);
	            }
	          }
		    str = br.readLine();
	    }
	}
}
