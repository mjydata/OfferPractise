package offer1;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class test56 {
   /* boolean isSymmetrical(TreeNode pRoot)
    {
        TreeNode NRoot=Mirror(pRoot);
        return isSymmetrical(pRoot,NRoot);
    }
    boolean isSymmetrical(TreeNode pRoot,TreeNode NRoot){
        if (pRoot == null && NRoot == null) {
            return true;
        } else if (
                (pRoot == null && NRoot!= null) ||
                        (pRoot != null && NRoot== null) ||
                        pRoot.val != NRoot.val ||
                        !isSymmetrical(pRoot.left, NRoot.left) ||
                        !isSymmetrical(pRoot.right, NRoot.right)) {
            return false;
        } else {
            return true;
        }
    }
    TreeNode  Mirror(TreeNode pRoot){
        if (pRoot==null){
            return null;
        }
        if (pRoot.left==null&&pRoot.right==null){
            return pRoot;
        }
        TreeNode temp=pRoot.left;
         pRoot.left=pRoot.right;
         pRoot.right=temp;
         if (pRoot.left!=null){
             Mirror(pRoot.left);
         }
         if (pRoot.right!=null){
            Mirror(pRoot.right);
        }
        return pRoot;
    }
*/
   boolean isSymmetrical(TreeNode pRoot)
   {
      if (pRoot==null){
          return true;
      }
       return comRoot(pRoot.left,pRoot.right);
    }
    boolean comRoot(TreeNode left,TreeNode right){
        if (left==null){
            return right==null;
        }
        if (right==null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
        return comRoot(left.left,right.right)&&comRoot(left.right,right.left);
    }

}

