package offer1;
/**
 * 输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author mjy
 *
 */
public class test26 {

        treeNode head = null;
        treeNode realHead = null;
        public treeNode Convert(treeNode pRootOfTree) {
            ConvertSub(pRootOfTree);
            return realHead;
        }

        private void ConvertSub(treeNode pRootOfTree) {
            if(pRootOfTree==null) return;
            ConvertSub(pRootOfTree.left);
            if (head == null) {
                head = pRootOfTree;
                realHead = pRootOfTree;
            } else {
                head.right = pRootOfTree;
                pRootOfTree.left = head;
                head = pRootOfTree;
            }
            ConvertSub(pRootOfTree.right);
        }

}
class treeNode {
    int val;
    treeNode left;
    treeNode right;
    treeNode(int val){
        this.val=val;
    }
}