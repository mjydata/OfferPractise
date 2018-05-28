package practise;

import java.util.LinkedList;
import java.util.Queue;

public class levelTree {
   
	public void levelOrder(TreeNode root) {
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			root= queue.poll();
			if (root.left!=null) {
				queue.offer(root.left);
			}
			if (root.right!=null) {
				queue.offer(root.right);
			}
		}
	}
}
