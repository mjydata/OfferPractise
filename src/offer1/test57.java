package offer1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class test57 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Deque<TreeNode> current=new LinkedList();
        Deque<TreeNode> reverse=new LinkedList();
        if (pRoot==null){
            return res;
        }
        boolean flag=false;//从左至右，
        current.push(pRoot);
        while(!current.isEmpty()||!reverse.isEmpty()){
            if (flag){
                ArrayList<Integer> lists=new ArrayList<>();
                while(!reverse.isEmpty()){
                    TreeNode root=reverse.pop();
                    lists.add(root.val);
                    if (root.right!=null){
                        current.push(root.right);
                    }
                    if (root.left!=null){
                        current.push(root.left);
                    }
                }
                flag=false;
                if (lists.size()!=0){
                    res.add(lists);
                }


            }
            if (!flag){
                ArrayList<Integer> lists=new ArrayList<>();
                while(!current.isEmpty()) {
                    TreeNode root = current.pop();
                    lists.add(root.val);
                    if (root.left != null) {
                        reverse.push(root.left);
                    }
                    if (root.right != null) {
                        reverse.push(root.right);
                    }
                }
                flag=true;
                if (lists.size()!=0){
                    res.add(lists);
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        System.out.print(Print(n1));
    }
}
