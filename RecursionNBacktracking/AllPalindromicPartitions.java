package RecursionNBacktracking;

public class AllPalindromicPartitions {
	public static boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		
		while (i < j) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(j);
			if (c1 != c2) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void solution(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
		}
		for (int i = 1; i <= str.length(); i++) {
			String s = str.substring(0, i);
			if (isPalindrome(s)) {
				solution(str.substring(i), asf +"(" + s + ") ");
			}
		}
	}
	
	public static void main(String args[]) {
		solution("pepper", "");
	}
}
