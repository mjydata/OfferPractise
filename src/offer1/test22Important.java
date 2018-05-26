package offer1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 层次遍历
 */
public class test22Important {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode2 root) {
		ArrayList<Integer> list=new ArrayList<>();
		if(root==null){
			return list;
		}
		Queue<TreeNode2> queue =new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode2 node2=queue.poll();
			if (node2.left!=null) {
				queue.offer(node2.left);
			}
			if (node2.right!=null) {
				queue.offer(node2.right);
			}
			list.add(node2.val);
		}
		return list;
	}
}
