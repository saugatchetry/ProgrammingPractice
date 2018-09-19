package Tree;
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        TreeNode lca = lowestCommonAncestor(root, root.left.left, root.left.right);
        System.out.println("LCA = "+lca.data);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root,TreeNode first, TreeNode second) {
        if(root == null){
            return null;
        }

        if(root == first || root == second){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, first, second);
        TreeNode right = lowestCommonAncestor(root.right, first, second);
        if(left != null && right != null){
            return root;
        }
        else{
            return left!=null ? left:right;
        }
    }
}
