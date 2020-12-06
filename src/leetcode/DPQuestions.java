package leetcode;


import java.net.Socket;
import java.util.*;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author T-Cool
 * @date 2020/11/1 ����11:31
 */
public class DPQuestions {
    public static  int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();

        CountDownLatch
        int  left = 0;
        int  right= -1;

        int ans =1 ;
        int  n=s.length();

        //��ָ��
        for (int i =0;i<n;++i){
            if (i!=0){
                set.remove(s.charAt(i-1));
            }
            //��ָ��
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
     * ����һ���������ַ������� strs ���������� m �� n ��
     *
     * �����ҳ������� strs ������Ӽ��Ĵ�С�����Ӽ��� ��� �� m �� 0 �� n �� 1 ��
     *
     * ��� x ������Ԫ��Ҳ�� y ��Ԫ�أ����� x �Ǽ��� y �� �Ӽ� ��
     *
     * ���⣺
     * ת�Ʒ��̣�
     * f[m][n] = max(f[m][n],1+f[m-cost_zeros(s)][m-cost_ones(s)])
     *
     * cost_zero[k] �� cost_one[k] ��ʾ���ַ����� 0 �� 1 �ĸ�����
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
     * ����һ��������ת��������������ı�ͷ��
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
     * �жϸ������������Ƿ��л�
     * ��չ��
     * ���ܸ����ռ临�ӶȵĽⷨô��
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
     * ǰ��
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
     * ����
     * @param
     */
   //�ݹ�
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
     *�������
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
                //���ֽڵ�ŵ�set
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
     * ������
     * �������µ���
     */
    public void heapify(int[] tree , int n ,int i ){
        if (i>n) return;

        // ��ڵ�
        int c1 = (2*i +1) ;
        //�ҽڵ�
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
     * �ӵ����ڶ����������¹�����
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
            //ÿ��ֻ����������Ķ�
            heapify(tree,i,0);
        }
    }

    /**
     * ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        buildHeap(nums,nums.length);
        for (int i = nums.length-1 ;i >= nums.length-k ;i--){
            swap(nums,0,i);
            //ÿ��ֻ����������Ķ�
            heapify(nums,i,0);
        }


        return nums[nums.length-k];
    }

    /**
     *����һ���������ַ�'(',')','{','}','['��']',���ַ������жϸ������ַ����Ƿ��ǺϷ�����������
     * ���ű�������ȷ��˳��رգ�"()"��"()[]{}"���ǺϷ����������У���"(]"��"([)]"���Ϸ���
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
     * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
     * f(n)=f(n-1)+f(n-2)+...+f(1)
     * f(n-1)=f(n-2)+...f(1)
     * ��:f(n)=2*f(n-1)
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
     * �����������
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
     *����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣 �������
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
     * �ж϶���ƽ����
     *������Ե����ϵĵݹ�
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
     *���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
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
     *    ��������������� [1,-2,3,10,-4,7,2,-5]
     *    �±�Ϊi�����������ĺ� dp[i] = max(array[i],dp[i-1]+array[i])
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
     * ��ΪS��������������
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
     * ������
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
     * ��α���
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
     * ֮�ֱ���������������ջ
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
