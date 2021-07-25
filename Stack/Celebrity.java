package Stack;
import java.io.*;
import java.util.Stack;

class Celebrity {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);
    }
    public static void findCelebrity(int arr[][]) {
        Stack<Integer> stk = new Stack<>();
        for (int i= 0; i < arr.length; i++) {
            stk.push(i);
        }

        while(stk.size() >= 2) {
            int i = stk.pop();
            int j = stk.pop();
            if (arr[i][j] == 1) {
                stk.push(j);
            }
            else {
                stk.push(i);
            }
        }

        int potential = stk.pop();
        for (int i = 0; i < arr.length; i++) {
            if (i != potential) {
                if (arr[i][potential] == 0 || arr[potential][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potential);
    }
}
