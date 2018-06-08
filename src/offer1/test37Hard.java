package offer1;
/*
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class test37Hard {
    public static int treeDepth(TreeNode3 root) {
      if (root==null){
          return  0;
      }
      int left=treeDepth(root.leftNode);
        int right=treeDepth(root.rightNode);
        return left>right ? left+1: right+1;
    }
    public static  void main(String[] args){
        TreeNode3 root=new TreeNode3(1);
        root.leftNode=new TreeNode3(2);
        root.rightNode=new TreeNode3(3);
        System.out.print(treeDepth(root));

    }
}
class TreeNode3{
    int val;
    TreeNode3 leftNode;
    TreeNode3 rightNode;
    public TreeNode3(int val) {
        this.val=val;

    }
}
/*
输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。例如，下图中的二叉树就是一棵平衡二叉树。

public static bool IsBalancedBinaryTree(BinaryTreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        int left = GetTreeDepth(root.LeftChild);
        int right = GetTreeDepth(root.RightChild);
        int diff = left - right;

        if (diff > 1 || diff < -1)
        {
            return false;
        }

        return IsBalancedBinaryTree(root.LeftChild) && IsBalancedBinaryTree(root.RightChild);
    }

 */