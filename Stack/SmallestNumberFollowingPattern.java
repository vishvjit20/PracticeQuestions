package Stack;
import java.util.*;

public class SmallestNumberFollowingPattern {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		Stack<Integer> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = 1;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'd') {
				stk.push(n);
				n++;
			}
			else {
				stk.push(n);
				n++;
				while (stk.size() > 0) sb.append(stk.pop());
			}
		}
		stk.push(n);
		while (stk.size() > 0) sb.append(stk.pop());
		
		System.out.println(sb.toString());
		sc.close();
	}
}
