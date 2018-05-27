package offer1;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

 * @author mjy
 *
 */
public class test24 {
	ArrayList<Integer> list1=new ArrayList<>();
	ArrayList<ArrayList<Integer>> list2=new ArrayList<>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if(root== null){
			return null;
		}
		list1.add(root.val);
		target-=root.val;
		if (target==0&&root.leftNode==null&&root.rightNode==null) {
			list2.add(new ArrayList<>(list1));
		}
		FindPath(root.leftNode, target);
		FindPath(root.rightNode, target);
		list1.remove(list1.size()-1);
		return list2;
	}
}
