package offer1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class test58 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue1=new LinkedList<>();
        ArrayList<Integer> tmp=new ArrayList<Integer>();
        queue1.offer(pRoot);
        int now   =1 ,next=0;
        if(pRoot == null)
            return res;
        while(!queue1.isEmpty()){
               TreeNode root=queue1.poll();
               tmp.add(root.val);
               now--;
               if (root.left!=null){
                   queue1.offer(root.left);
                   next++;
                }
                if (root.right!=null){
                    queue1.offer(root.right);
                    next++;
                }
            if(now == 0) {
                res.add(new ArrayList<Integer>(tmp));
                tmp.clear();
                now = next;
                next = 0;
            }

        }
        return res;
    }
}
