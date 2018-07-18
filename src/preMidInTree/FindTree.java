package preMidInTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 深度优先遍历：这种遍历算法将先访问到树中最深层次的节点。 
    广度优先遍历：这种遍历算法将逐层访问每层的节点，广度优先遍历又被称为按层遍历。
 先（前）序遍历，分三步： 
（1）访问根节点 
（2）递归遍历左子树 
（3）递归遍历右子树 
中序遍历 
（1）递归遍历左子树 
（2）访问根节点 
（3）递归遍历右子树 
后序遍历 
（1）递归遍历左子树 
（2）递归遍历右子树 
（3）访问根节点 
 * @author mjy
 *
 */
public class FindTree {
	/**
	 * 前序遍历 递归
	 * @param root
	 */
   public void preFind(TreeNode root){
	   if (root==null) {
		return;
	}
	   System.out.println(root.val);
	   preFind(root.left);
	   preFind(root.right);
   }
   /**
	 * 中序遍历 递归
	 * @param root
	 */
   public void midFind(TreeNode root){
	   if (root==null) {
		return;
	}

	   midFind(root.left);
	   System.out.println(root.val);
	   midFind(root.right);
   }
   /**
  	 * 后序遍历 递归
  	 * @param root
  	 */
     public void inFind(TreeNode root){
  	   if (root==null) {
  		return;
  	}
  	  
  	   preFind(root.left);
  	   preFind(root.right);
  	 System.out.println(root.val);
     }
     /**
 	 * 前序遍历 非递归
     *  
     * @param root 树根节点 
     * 利用栈实现循环先序遍历二叉树 
     * 这种实现类似于图的深度优先遍历（DFS） 
     * 维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。 
     * 这种方式应该是对先序遍历的一种特殊实现（看上去简单明了），但是不具备很好的扩展性，在中序和后序方式中不适用 
     
 	 */
     public void preOrder_1(TreeNode root){
    	 Stack<TreeNode> stack = new Stack<>();
    	 if (root ==null) {
			return;
		}
    	 stack.push(root);
    	 while (!stack.isEmpty()) {
			System.out.println(stack.pop());
			if (root.right!=null) {
				stack.push(root.right);
			}
			if (root.left!=null) {
				stack.push(root.left);
			}
		}
     }
     /** 
      *  
      * @param root 树的根节点 
      * 利用栈模拟递归过程实现循环先序遍历二叉树 
      * 这种方式具备扩展性，它模拟递归的过程，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树 
      */
     public void preOrder_2(TreeNode root){
         if(root==null)return;  
    	 Stack<TreeNode> stack=new Stack<>();
    	 while (root!=null || !stack.isEmpty()){//????????为什么是或呢： 只要有一个条件为真都进入while循环
    		 while(root!=null ){
    			 System.out.println(root.val);//先访问再入栈
        		 stack.push(root);
        		 root=root.left;
        	 }	 
    		 root=stack.pop();
    		 root=root.right;
    	 }  	 
     }
     /**
      *中序遍历 非递归
      *@param root 树根节点 
     * 利用栈模拟递归过程实现循环中序遍历二叉树 
     * 思想和上面的preOrderStack_2相同，只是访问的时间是在左子树都处理完直到null的时候出栈并访问。 
      */
     public void midOrder(TreeNode root){
    	 if (root==null) {
			return;
		}
    	 Stack<TreeNode>  stack =new Stack<>();
    	 while (root!=null || stack.isEmpty()){
    		 while(root!=null){	
    			 stack.push(root);
    			 root=root.left;
    		 }
    		 root =stack.pop();
    		 System.out.println(root);
    		 root=root.right;
    		 
    	 }
     }
     /**
      * s1为辅助堆栈，s2为真正的目标堆栈
 * 基本思路是后序遍历应该怎样输出，堆栈s2的元素就应该按后序遍历的逆序入栈
 * s1出栈顺序决定s2的入栈顺序，所以如何控制s1的出入栈是算法的核心
      */
     public void inOrder(TreeNode root) {
    	 if (root==null) {
 			return;
 		}
		Stack< TreeNode> stack1=new Stack<>();//辅助	
		Stack< TreeNode> stack2=new Stack<>();//目标栈
		stack1.push(root);
		while(!stack1.isEmpty()){
			root=stack1.pop();
			stack2.push(root);
			if (root.left!=null) {
				stack1.push(root.left);
			}
			if (root.right!=null) {
				stack1.push(root.right);
			}
		}
		while(stack2!=null){
            System.out.print(stack2.pop());
        }
	}
     /**
      * 层次遍历
      */
     public void levelOrder1(TreeNode root) {
		if (root==null) {
			return ;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			root=queue.poll();
			System.out.println(root.val);
			if (root.left!=null) {
				queue.offer(root.left);
			}
			if (root.right!=null) {
				queue.offer(root.right);
			}
		}
	}
}
class TreeNode{
	int  val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
     	this.val=val;
	}
}