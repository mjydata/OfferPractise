package leetcode;

/**
 * 226. Invert Binary Tree
 */
public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        mirror(root);
        return root;
    }
    public void mirror(TreeNode root) {
        if(root==null) return ;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirror(root.right);
        mirror(root.left);
    }
}

