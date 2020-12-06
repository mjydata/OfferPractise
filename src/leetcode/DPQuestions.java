package leetcode;


import java.net.Socket;
import java.util.*;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author T-Cool
 * @date 2020/11/1 下午11:31
 */
public class DPQuestions {
    public static  int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();

        CountDownLatch
        int  left = 0;
        int  right= -1;

        int ans =1 ;
        int  n=s.length();

        //左指针
        for (int i =0;i<n;++i){
            if (i!=0){
                set.remove(s.charAt(i-1));
            }
            //右指针
            while (right+1 <n && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }
            ans = Math.max(ans,set.size());
        }
        return ans;
    }


    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }

        return  true;

    }

    public static int coinChange(int[] coins, int amount) {
        //f(amount) = min{f(amount-couns[0])+1,...,f(amount-couns[i])+1}
        int[] f = new int[amount+1];
        f[0]= 0;
        int i ,j ;
        for(j= 1;j<=amount ;j++){
            f[j] = Integer.MAX_VALUE;
            for(i = 0 ; i< coins.length; i++){
                if(j-coins[i]>=0 && f[j-coins[i]] != Integer.MAX_VALUE){
                    f[j]=Math.min(f[j-coins[i]]+1,f[j]);
                }
            }
        }
        if(f[amount] == Integer.MAX_VALUE){
            f[amount]=-1;
        }
        return f[amount];
    }

    public static  int uniquePaths(int m, int n) {

        int[][] f = new int[m][n] ;
        f[0][0] = 0;
        int i,j;
        for (i = 0 ; i< m ;i++ ){
            for (j = 0 ; j< n ;j++ ) {
                if (i==0|| j==0){
                    f[i][j]=1;
                }else {
                    f[i][j] = f[i-1][j]+f[i][j-1];

                }
            }
        }
        return f[m-1][n-1];
    }
    public boolean canJump(int[] nums) {

        int n = nums.length;
        boolean[] f = new boolean[n];

        f[0] =true;
        for (int i =1 ;i<n ;i++){
            f[i] =false;
            //preview stone j
            // j-> i
            for (int j = 0 ;j<i;j++){
                if (f[j] && nums[j]>=i-j){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n-1];
    }

    /**
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     *
     * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
     *
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     *
     * 解题：
     * 转移方程：
     * f[m][n] = max(f[m][n],1+f[m-cost_zeros(s)][m-cost_ones(s)])
     *
     * cost_zero[k] 和 cost_one[k] 表示该字符串中 0 和 1 的个数。
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0 ;
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);

        }
        return dp[m][n];
    }

    public static int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {

        if(head==null || head.next == null ){return head;}
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null ){
           ListNode tmp  = curr.next;
           curr.next = pre;
           pre = curr;
           curr = tmp;
        }

        return pre;
    }


    /**
     * 判断给定的链表中是否有环
     * 扩展：
     * 你能给出空间复杂度的解法么？
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(first != null&& first.next !=null){
            first = first.next.next;
            second = second.next;
            if(first == second){
                return true;
            }
        }
        return false;

    }

    /**
     * 前序
     * @param
     */
    //   1
    // 2   3
    public void  preTree(TreeNode root){
        if (root==null) return;
        while (root!=null){
            System.out.println(root.val);
            midTree(root.left);
            midTree(root.right);
        }

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        if (root == null) {
            return res;
        }
        while(root!=null || !stk.isEmpty()){
            while(root!= null ){
                res.add(root.val);
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            root = root.right;

        }

        return res;

    }

    /**
     * 中序
     * @param
     */
   //递归
    public void midTree(TreeNode root){
        if (root==null) return;
        while (root!=null){
            midTree(root.left);
            System.out.println(root.val);
            midTree(root.right);
        }

    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null){
                stk.add(root);
                root=root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


    /**
     *后序遍历
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        HashSet<TreeNode> treeNodes = new HashSet<>();
        if (root == null) return res;
        while (root != null || !stk.isEmpty()) {
            if (root == null && treeNodes.contains(stk.peek())){
                res.add(stk.pop().val);
            }else if (root == null ){
                //把又节点放到set
                treeNodes.add(stk.peek());
                root =stk.peek().right;
            }else {
                stk.push(root);
                root = root.left;
            }
        }
        return res;
    }


    /**
     * 堆排序
     * 依次向下调整
     */
    public void heapify(int[] tree , int n ,int i ){
        if (i>n) return;

        // 左节点
        int c1 = (2*i +1) ;
        //右节点
        int c2 = (2*i +2) ;
        int max =i ;
        if (c1 < n && tree[max] < tree[c1]){
            max =c1;
        }
        if (c2 < n && tree[max]<tree[c2]){
            max = c2;
        }
        if (max != i){
            swap (tree,max,i) ;
            heapify(tree,n,max);
        }
    }

    public void swap (int[] tree , int max ,int i){
        int temp = tree[max];
        tree[max]= tree [i];
        tree[i] = temp ;
    }

    /**
     * 从倒数第二层依次往下构建堆
     * @param tree
     * @param n
     */
    public void buildHeap (int[] tree,int n ){
        int lastNode = n-1 ;
        int parent = (lastNode -1)/2;
        for (int i = parent ; i >= 0 ;i-- ){
            heapify(tree,n,i);
        }
    }

    public void heapSort(int[] tree, int n ){
        buildHeap(tree,n);
        for (int i = n-1 ;i >= 0 ;i--){
            swap(tree,0,i);
            //每次只更新最上面的堆
            heapify(tree,i,0);
        }
    }

    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        buildHeap(nums,nums.length);
        for (int i = nums.length-1 ;i >= nums.length-k ;i--){
            swap(nums,0,i);
            //每次只更新最上面的堆
            heapify(nums,i,0);
        }


        return nums[nums.length-k];
    }

    /**
     *给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     *
     */
    public boolean isValid12 (String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c =='(')
                stack.push(')');
            else if(c =='[')
                stack.push(']');
            else if(c =='{')
                stack.push('}');
            else if(stack.empty()||stack.pop()!=c)
                return false;
        }
        return stack.empty();
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * f(n)=f(n-1)+f(n-2)+...+f(1)
     * f(n-1)=f(n-2)+...f(1)
     * 得:f(n)=2*f(n-1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {

        int[] dp = new int[target+1];
        if (target == 0 ){
            return 0;
        }
        if (target == 1 ){
            return 1;
        }
        if (target == 2 ){
            return 2;
        }
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for (int i=2;i<=target;i++){
            dp[i]=dp[i-1]+1+dp[i-2];
        }
        return dp[target];

    }

    /**
     * 二叉树的深度
     * @param root
     * @return
     */

    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return 1+( (left>right)? left:right);

    }

    /**
     *给定一棵二叉搜索树，请找出其中的第k小的结点。 中序遍历
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot == null ){
            return pRoot;
        }
        Deque<TreeNode> stack = new LinkedList<>();

        List<TreeNode> res = new LinkedList<>();
        while (pRoot !=null || !stack.isEmpty()){
            while (pRoot != null ){
                stack.push(pRoot);
                pRoot= pRoot.left;
            }
            pRoot = stack.pop();
            res.add(pRoot);
            pRoot = pRoot.right;
        }
        return res.get(k);
    }


    /**
     * 判断二叉平横树
     *这个是自底向上的递归
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
       if (root == null ) return 0;
       int left = height(root.left);
       int right = height(root.right);

       if (left ==-1 || right == -1 || Math.abs(left-right)>1 ){
           return  -1 ;
       }else {
           return Math.max(left,right) +1 ;
       }
    }


    /**
     *输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode res=null;
        if(list1.val<list2.val){
            res=list1;
            list1.next=Merge(list1.next,list2);
        }
        else{
            res=list2;
            list2.next=Merge(list1,list2.next);
        }
        return res;

    }


    /**
     *    连续子数组的最大和 [1,-2,3,10,-4,7,2,-5]
     *    下标为i的最大子数组的和 dp[i] = max(array[i],dp[i-1]+array[i])
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int m = array.length;
        int[] dp = new int[m];
        dp[0] = array[0];
        int amx =array[0] ;
        for (int i =1;i<m;i++){
            dp[i]= Math.max(array[i],dp[i-1]+array[i]);
            amx = Math.max(amx,dp[i]);
        }
        return amx;
    }

    /**
     * 和为S的连续正数序列
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int low = 1 ;
        int high = 2 ;
        while (low < (sum+1)/2 ){
            int count = (low +high)*(high-low+1)/2 ;
            if (count == sum ){
                ArrayList<Integer> sub = new ArrayList<>();
                for (int i = low ;i<=high ; i++){
                    sub.add(i);
                }
                res.add(sub);

                low++;
            }else if (count<sum ){
                high ++ ;
            }else {
                low ++;
            }
        }
        return res;
    }


    /**
     * 剪绳子
     *
     * @param len
     * @return
     */
    public int cutRope(int len){
        if(len < 2)
            return 0;
        if(len == 2)
            return 1;
        if(len == 3)
            return 2;
        int []result = new int[len + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        int max = 0;
        for(int i= 4; i <= len; i++){
            max = 0;
            for(int j = 1; j <= i /2; j++){
                int tempResult = result[j] * result[i - j];
                if(max < tempResult)
                    max = tempResult;
                result[i] = max;
            }
        }
        return max;
    }


    /**
     * 层次遍历
     * root->left->right
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList();
        if (root==null) return res;
        queue.offer(root);
        while (queue.peek()!=null){
            ArrayList<Integer> treeNodes = new ArrayList<>();
            int currSize = queue.size();
            for (int i = 0;i< currSize;i++){
                TreeNode node = queue.poll();
                treeNodes.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(treeNodes);
        }
        return res;
    }


    /**
     * 之字遍历二叉树：两个栈
     *
     *             1
     *          2     3
     *        4   5 6  7
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(pRoot);

        while (!s1.isEmpty() || !s2.isEmpty()){

            if (!s1.isEmpty()){
                ArrayList<Integer> tmp = new ArrayList<>();

                while (!s1.isEmpty()){
                    TreeNode tme = s1.pop();
                    tmp.add(tme.val);
                    if (tme.left!=null ){
                        s2.push(tme.left);
                    }
                    if (tme.right!=null ){
                        s2.push(tme.right);
                    }
                }
                result.add(tmp);

            }else {
                ArrayList<Integer> tmp = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode tme = s2.pop();
                    tmp.add(tme.val);
                    if (tme.right != null) {
                        s1.push(tme.right);
                    }
                    if (tme.left != null) {
                        s1.push(tme.left);
                    }
                }
                result.add(tmp);

            }
        }
        return result;

    }


    public static void main(String[] arfs){

        Socket socket = new Socket();
        socket.connect();

        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println( new DPQuestions().FindContinuousSequence(9));
    }



}
