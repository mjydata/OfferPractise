package offer1;

import java.util.ArrayList;

/**
 * 给定一棵二叉搜索树，请找出其中的第k大的结点
 *中需
 */
public class test60 {
    ArrayList<TreeNode> lists=new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (k==0||k>lists.size()){
            return null;
        }

        return  midFind(pRoot,k);

    }
    TreeNode midFind(TreeNode pRoot,int k){

        if (pRoot==null){
          return null;
        }

        midFind(pRoot.left,k);
        lists.add(pRoot);
        if (lists.size()==k){
            return pRoot;
        }
        midFind(pRoot.right,k);
        return  null;
    }
}
