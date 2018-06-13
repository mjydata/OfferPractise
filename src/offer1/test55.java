package offer1;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。


 如果节点存在右子树：那么它的下一个节点就是右子树中的最左节点；
 如果节点没有右子树：
 节点为其父节点的左子节点，那么其父节点就是它的下一个节点；
 节点为其父节点的右子节点，那么需要沿其父指针一直向上遍历，一直找到某个节点是其父节点的左子节点为止，那么这个节点的父节点即是需要寻找的下一个节点。
 */
public class test55 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        if (pNode.right!=null){

             pNode=pNode.right;
             while (pNode.left!=null){
                 pNode=pNode.left;
             }
             return pNode;
        }else{
            while(pNode.next != null) { //非根节点
                if (pNode.next.left == pNode) {
                    return pNode.next;
                }
                pNode=pNode.next;

            }
        }
        return null;

    }


}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}