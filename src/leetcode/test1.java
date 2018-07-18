package leetcode;


/**
 Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class test1 {
    public int run(TreeNode root) {
       if(root==null){
           return 0;
       }else if(root.left!=null && root.right !=null){
            int min_left=run(root.left);
            int min_right=run(root.right);
            return min_left>min_right?min_right+1:min_left+1;
       }else if(root.right!=null){
           return run(root.right)+1;
       }else {
           return  run(root.left)+1;
       }
    }
}
