package leetcode;

/**
 * 238
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Example:

 Input:  [1,2,3,4]
 Output: [24,12,8,6]
 Note: Please solve it without division and in O(n).

 Follow up:
 Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < result.length; i++) result[i] = 1;

        for (int i = 1; i < nums.length; i++) {// 先正着来一遍，只乘到前一个元素
            result[i] = result[i-1] * nums[i-1];
        }

        int behind = 1;
        for (int i = nums.length-1; i >= 0; i--) {// 再倒着来一遍，乘以后面的数
            result[i] = result[i] * behind;
            behind = behind * nums[i];
        }

        return result;
    }
}
