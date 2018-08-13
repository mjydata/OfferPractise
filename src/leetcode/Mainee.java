package leetcode;

import java.util.*;

public class Mainee {



    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int k=scanner.nextInt();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<n;i++){
            stringBuilder.append("a");
        }
        for (int i=0;i<m;i++){
            stringBuilder.append("z");
        }
        String firstStr=stringBuilder.toString();
        char[] arr=firstStr.toCharArray();

        List<List<Character>> tmp2 =permuteUnique(arr);
        List<String> list=new ArrayList<String>() ;
        Iterator iterator=tmp2.iterator();
        while(iterator.hasNext()){

        }
        for (List<Character> list1:tmp2){
            StringBuilder sv=new StringBuilder();;
            for (char ch: list1){

                sv.append(ch);
            }
            list.add(sv.toString());
        }

        Collections.sort(list,new Realize_Comparator());

        System.out.print(list.get(k-1));

    }
   static List<List<Character>> ret = new ArrayList<>();
  static   List<Character> tmp = new ArrayList<>();

    public static List<List<Character>> permuteUnique(char[] nums) {
        boolean[] vis = new boolean[nums.length];
        // 排序
        Arrays.sort(nums);
        dfs(nums, 0, nums.length, vis);
        return ret;
    }

    // DFS+回溯
    private static void dfs(char[] nums, int idx, int len, boolean vis[]) {
        if (tmp.size() == len) {
            ret.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < len; i++) {
            if (vis[i])
                continue;
            // 遇到已经加过的元素就跳过
            vis[i] = true;
            // 加入该元素后继续搜索
            tmp.add(nums[i]);
            // 可以不传i+1参数，但是递归次数增多
            dfs(nums, i + 1, len, vis);
            tmp.remove(tmp.size() - 1);
            vis[i] = false;
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;

        }
    }


}
 class Realize_Comparator implements Comparator<String> {// <>内的类型是自定义的类型,规定的作用是,当调用这个方法时需要传入的数据类型


     @Override
     public int compare(String arg0, String arg1) {// 重写compare比较方法,在这里可以根据编程需要进行自定义
         // TODO Auto-generated method stub
         return arg0.compareTo(arg1);// 利用String数组自带的compareTo方法对传入的两个字符串进行按字典顺序比较两个字符串。
     }
 }