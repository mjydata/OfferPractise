package offer1;
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * @author mjy
 *
 */
public class test17 {
	public boolean HasSubtree(TreeNode1 Tree1,TreeNode1 Tree2){
		Boolean shift=false;
		
		if (Tree1.val==Tree2.val) {
			shift= doesTree1Has(Tree1, Tree2);
		}
		if (!shift) {
			shift=doesTree1Has(Tree1, Tree2.left);
		}
		if (!shift) {
			shift=doesTree1Has(Tree1, Tree2.right);
		}
	return shift;
	}
	public boolean doesTree1Has(TreeNode1 Tree1,TreeNode1 Tree2) {
		if (Tree1==null||Tree2==null) {
			return false ;
		}
		if(Tree1.val==Tree2.val){
			return doesTree1Has(Tree1.left, Tree2.left)&&doesTree1Has(Tree1.right, Tree2.right);
		}else{
			return false ;
		}
			
	}
}
class TreeNode1{
	int val;
	TreeNode1 left=null;
	TreeNode1 right=null;
	public TreeNode1(int val) {
		this.val=val;
	}
	
}