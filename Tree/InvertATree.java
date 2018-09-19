package Tree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertATree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        invertTree(root);

    }

    private static void invertTree(TreeNode root) {
        if(root == null){
            return;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    private static void printInOrderTree(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(root != null){
                stack.add(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                root = stack.pop();
                System.out.print(root.data+" ");
                root = root.right;
            }
        }
    }

    private static void printPreOrderTree(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right != null){
                stack.add(temp.right);
            }
            if(temp.left != null){
                stack.add(temp.left);
            }
        }
    }

    public static void printTreeLevelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();

            if(temp != null){
                System.out.print(temp.data +" ");

                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
            else{
                System.out.print(" null ");
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }
    }
}
