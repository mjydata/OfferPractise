package leetcode;
/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

dp 动态规划
 */
public class Maximum_Subarray {
    public  int maxSubArray(int[] nums) {
        int m=nums.length;
        int[] dp=new int[m];
        dp[0]=nums[0];
        int answer=dp[0];
        for(int i=1;i<m;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            answer=Math.max(answer,dp[i]);
        }
        return answer;
    }

}
