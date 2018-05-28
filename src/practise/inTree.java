package practise;

import java.util.Stack;

public class inTree {
   //递归	
	public void inOrder(TreeNode root) {
		if (root==null) {
			return ;
		}
		inOrder(root.right);
		inOrder(root.left);
		System.out.println(root.val);
	}
	public void inOrder_2(TreeNode root) {
		if (root==null) {
			return ;
		}
		Stack<TreeNode> stack1=new Stack<>();
		Stack<TreeNode> stack2=new Stack<>();
		stack1.push(root);
		while(!stack1.isEmpty()){
			root= stack1.pop();
		    stack2.push(root);
		    if (root.left!=null) {
		    	stack1.push(root.left);
			}
		    if (root.right!=null) {
		    	stack1.push(root.right);
			}
		}
		while(!stack2.isEmpty()){
			System.out.println(stack2.pop());
		}
	}
}
