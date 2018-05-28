package practise;

import java.util.Stack;



public class midTree {
   //递归	
	public void midTree(TreeNode root){
		if (root== null){
			return;
		}
		midTree(root.left);
		System.out.println(root.val);
		midTree(root.right);
	}
	public void midTree_2(TreeNode root){
		if (root== null){
			return;
		}
		Stack<TreeNode> stack=new Stack<>();
	    while(root!=null||!stack.isEmpty()){
	    	while (root!=null) {
				stack.push(root);
				root=root.left;				
			}
	    	root=stack.pop();
	    	System.out.println(root.val);
	    	root=root.right;
	    }
	}
}
