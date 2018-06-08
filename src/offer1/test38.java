package offer1;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。

 */
public class test38 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        int left=getTreeDepth(root.leftNode);
        int right=getTreeDepth(root.rightNode);
        if(Math.abs(left-right)>1){
           return false;
        }
        return IsBalanced_Solution(root.rightNode) && IsBalanced_Solution(root.leftNode);
    }
    public int getTreeDepth(TreeNode root){
         if (root==null){
             return  0;
         }
         int left=getTreeDepth(root.leftNode);
        int right=getTreeDepth(root.rightNode);
        return left>right ? left+1 : right+1;
    }
}
