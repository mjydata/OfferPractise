package offer1;
/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * @author mjy
 *
 */
public class test18 {
  public TreeNode2 reverse(TreeNode2 root){
	  if (root==null) {
		  return null;
	}
	 if (root.left==null) {
		 root.left=root.right;
		 reverse(root.left);
	}
	 if (root.right==null) {
		 root.right=root.left;
		 reverse(root.right);
	}    
		  if (root.left!=null&&root.right!=null) {
			TreeNode2 root2=root.left;
			root.left=root.right;
			root.right=root2;
			reverse(root.left);
			reverse(root.right);
		}
		return root;
	
  }
}
class TreeNode2{
	int val;
	TreeNode2 left;
	TreeNode2 right;
	public TreeNode2(int val) {
		this.val=val;
	}
}