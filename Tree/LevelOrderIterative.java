package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        printTreeLevelOrder(root);
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
