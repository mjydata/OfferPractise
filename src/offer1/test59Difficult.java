package offer1;

import java.util.LinkedList;
import java.util.List;

/**
* 请实现两个函数，分别用来序列化和反序列化二叉树
*
* 实际上如果二叉树的序列化是从根结点开始的话，那么相应的反序列化在根结点的数值读出来的时候就可以开始了。因此我们可以根据前序遍历的顺序来序列化二叉树，因为前序遍历是从根结点开始的。当在遍历二叉树碰到 NULL 指针时，这些 NULL 指针序列化成一个特殊的字符（比如‘$’）。另外，结点的数值之间要用一个特殊字符（比如’,’）隔开。


*/
public class test59Difficult {
    int index=-1;
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
