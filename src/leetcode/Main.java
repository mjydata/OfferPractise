package leetcode;

import leetcode.TreeNode;

import java.util.*;

public class Main {
    public static  void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int index=1;
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        for (int i=0;i<n;i++){
            List<Integer> list=new ArrayList<Integer>();
            String temp=scanner.nextLine();
            if (temp.length()!=0){
                String[] arr=temp.split(" ");
                for(String a:arr){
                    list.add(Integer.parseInt(a));

                }
            }

            list.add(i);
            lists.add(list);
        }
        System.out.print(lists);
    }
     public static void preTree(TreeNode root){
        if (root==null){return;}
        Stack<TreeNode> stack=new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            System.out.print(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }


        }
     }
     public static void middleTree(TreeNode root){
         if (root==null){return;}
         Stack<TreeNode> stack=new Stack();
         while (root!=null || !stack.isEmpty()){
             while (root!=null){
                 stack.push(root.left);
                 root=root.left;
             }
             root =stack.pop();
             System.out.print(root.val);
             root=root.right;
         }
     }
     public static  void levelTree(TreeNode root ){
        if (root==null) return;
         Queue<TreeNode> queue=new LinkedList<>();
         queue.offer(root);
         while (root!=null || !queue.isEmpty()){
             root=queue.poll();
             System.out.print(root.val);
             if (root.left!=null){
                 queue.offer(root.left);
             }
             if (root.right!=null){
                 queue.offer(root.right);
             }

         }
    }
}

