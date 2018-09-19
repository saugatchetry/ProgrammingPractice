package Tree;

import java.util.Stack;

/*
    Time complexity - O(n) where n == number of node
    Space Complexity - O(h) where h = height of the tree;
 */

public class PostOrderIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        printPostOrderIterative(root);
    }

    private static void printPostOrderIterative(TreeNode root) {

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.add(current);
                current = current.left;
            }
            else{
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else{
                    current = temp;
                }
            }
        }
    }
}
