package GenericTree;

import java.util.ArrayList;
import java.util.Stack;
import java.io.*;

public class SizeOfGenericTree {
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr) {
        Node root = null;
        Stack<Node> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) stk.pop();
            else {
                Node temp = new Node();
                temp.data = arr[i];

                if (!stk.isEmpty()) stk.peek().children.add(temp);
                else root = temp;
                stk.push(temp);
            }
        }
        return root;
    }

    public static int size(Node node) {
        int size = 0;
        for (Node child : node.children) {
            size += size(child);
        }
        size += 1;

        return size;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        
        Node root = construct(arr);
        int size = size(root);
        System.out.println(size);

    }
}
