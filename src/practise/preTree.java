package practise;

import java.util.Stack;

//前序遍历
public class preTree {
   //递归
	public void preTree_1(TreeNode root){
	   if (root==null) {
		return ;
	}
	   System.out.println(root.val);
	   preTree_1(root.left);
	   preTree_1(root.right);
   }
	//非递归
	public void preTree_2(TreeNode root){
		if(root==null){return;
		}
		Stack<TreeNode> stack=new Stack<>();
	
		while (root!=null||stack.isEmpty()){
			while (root!=null) {
				System.out.println(root.val);
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			root=root.right;
		}
	}
}
//非递归
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val=val;
	}
}