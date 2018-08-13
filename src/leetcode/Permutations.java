package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
46
 */
public class Permutations {
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        dfsCore(nums, 0, nums.length);
        // dfs(nums, 0, nums.length, vis);
        return ret;
    }

    // 使用交换
    private void dfsCore(int[] nums, int idx, int len) {
        if (idx == len) {
            // 找到转置完成后的解，将其存入列表中
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(nums[i]);
            }
            ret.add(list);
        }
        // 将当前位置的数跟后面的数交换，并搜索解
        for (int i = idx; i < len; i++) {
            swap(nums, idx, i);
            // 传入idx+1
            dfsCore(nums, idx + 1, len);
            swap(nums, idx, i);

        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] arfs){
        int[]  aa={1,2};
        System.out.println(new Permutations().permute(aa));
    }
}
